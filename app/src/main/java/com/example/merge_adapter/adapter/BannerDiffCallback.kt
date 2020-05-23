package com.example.merge_adapter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.merge_adapter.data.model.Banner

class BannerDiffCallback : DiffUtil.ItemCallback<Banner>() {

    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        if (oldItem.id != null && newItem.id != null) return oldItem.id == newItem.id
        return false
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.id == newItem.id &&
            oldItem.bannerImage == newItem.bannerImage
    }
}