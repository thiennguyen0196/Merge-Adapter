package com.example.merge_adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout_right.view.*
import com.example.merge_adapter.R
import com.example.merge_adapter.data.model.User

class RightAdapter : ListAdapter<User, RightAdapter.RightViewHolder>(UserDiffCallback()) {

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RightViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_right, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RightViewHolder, position: Int) = holder.bind(currentList[position])

    inner class RightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.tvName.text = user.name
            itemView.tvNickName.text = user.nickName
            itemView.ivAvatar.setImageURI(user.avatar)
        }
    }
}