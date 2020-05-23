package com.example.merge_adapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.merge_adapter.R
import com.example.merge_adapter.data.model.Banner
import kotlinx.android.synthetic.main.item_layout_banner.view.*

class BannerAdapter : ListAdapter<Banner, BannerAdapter.BannerViewHolder>(BannerDiffCallback()) {

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BannerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_banner, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Banner) {
            itemView.ivBanner.setImageResource(user.bannerImage)
        }
    }
}