package com.example.merge_adapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.merge_adapter.data.model.User

class UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        if (oldItem.id != null && newItem.id != null) return oldItem.id == newItem.id
        return false
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id &&
            oldItem.name == newItem.name &&
            oldItem.nickName == newItem.nickName &&
            oldItem.avatar == newItem.avatar
    }
}