package com.example.merge_adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout_left.view.*
import com.example.merge_adapter.R
import com.example.merge_adapter.data.model.User

class LeftAdapter(
) : ListAdapter<User, LeftAdapter.LeftViewHolder>(UserDiffCallback()) {

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LeftViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_left, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LeftViewHolder, position: Int) = holder.bind(currentList[position])

    inner class LeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            itemView.tvName.text = user.name
            itemView.tvNickName.text = user.nickName
            itemView.ivAvatar.setImageURI(user.avatar)
        }
    }
}