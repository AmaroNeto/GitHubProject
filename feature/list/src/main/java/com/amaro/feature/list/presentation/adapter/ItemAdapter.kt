package com.amaro.feature.list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amaro.feature.list.R
import com.amaro.feature.list.domain.model.Item
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class ItemAdapter(private val items: List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.content_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
            val title: TextView = itemView.findViewById(R.id.title)
            title.text = item.name

            val forks: TextView = itemView.findViewById(R.id.forkCount)
            forks.text = "forks: ${item.forksCount}"

            val stars: TextView = itemView.findViewById(R.id.starCount)
            stars.text = "stars: ${item.starCount}"

            val owner: TextView = itemView.findViewById(R.id.ownerName)
            owner.text = item.owner.login

            val imageView: ShapeableImageView = itemView.findViewById(R.id.ownerPhoto)

            val shapeAppearanceModel = imageView.shapeAppearanceModel.toBuilder()
                .setAllCornerSizes(50f)
                .build()

            imageView.shapeAppearanceModel = shapeAppearanceModel
            Glide.with(itemView)
                .load(item.owner.avatarUrl)
                .into(imageView)
        }
    }
}