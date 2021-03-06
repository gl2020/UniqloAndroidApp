package com.uniqlo.uniqloandroidapp.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.uniqlo.uniqloandroidapp.R
import com.uniqlo.uniqloandroidapp.data.Item
import com.uniqlo.uniqloandroidapp.ui.discover.DiscoverFragmentDirections
import kotlinx.android.synthetic.main.item_preview.view.*
import timber.log.Timber


class ItemPreviewAdapter :
    ListAdapter<Item, ItemPreviewAdapter.ItemPreviewViewHolder>(ItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPreviewViewHolder {
        val itemView = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_preview, parent, false)
        return ItemPreviewViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemPreviewViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

    class ItemPreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            val url = item.imageUrl
            showImage(url)
            itemView.setOnClickListener  {
                navigateToItemDetails(item, it)

            }
        }

        private fun showImage(url: String) {

            if (!url.isNullOrEmpty()) {
                Glide.with(itemView.context)
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.color.colorPrimaryLight) // doesn't work with resizing?
                    .into(itemView.image_preview)
            }

        }

        // opens a new page to view selected item
        private fun navigateToItemDetails(
            item: Item,
            view: View
        ) {
            val direction =
                DiscoverFragmentDirections.actionFragmentDiscoverDestToFragmentItemDetailsDest(
                    item.itemId)

            Timber.d("navigate to item details with id: %s", item.itemId)
            view.findNavController().navigate(direction)

        }

    }

    private object ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.itemId == newItem.itemId
//            return true
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

}