package com.common.components.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.common.components.R
import com.common.components.repository.models.UserModel


class UserListAdapter constructor(private val context: Context, private var users: List<UserModel>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder", "CheckResult")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView = inflater.inflate(R.layout.user_list_item, parent, false)
        val userImage = itemView.findViewById<ImageView>(R.id.user_list_profile_image)
        val userName = itemView.findViewById<TextView>(R.id.user_list_name_text_view)
        val userDescription = itemView.findViewById<TextView>(R.id.user_list_descripton_text_view)
        val userImageUrl = users[position].profile_image
        userName.text = users[position].title
        userDescription.text = users[position].description

        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_placeholder)
        requestOptions.error(R.drawable.ic_placeholder)

        Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
            .load(userImageUrl)
            .error(Glide.with(userImage).load(R.drawable.ic_placeholder))
            .into(userImage)

        return itemView
    }

    override fun getItem(position: Int): UserModel {
        return users[position]
    }

    override fun getItemId(position: Int): Long {
        return users.indexOf(getItem(position)).toLong()
    }

    override fun getCount(): Int {
        return users.size
    }

    fun setUserList(users: List<UserModel>) {
        this.users = users
        notifyDataSetChanged()
    }
}
