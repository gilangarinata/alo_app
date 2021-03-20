package com.gilangarinata.aloapps.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gilangarinata.aloapps.databinding.ItemAlbumBinding
import com.gilangarinata.aloapps.models.AlbumModel


/**
 * Created by Gilang Arinata on 10/01/21.
 * https://github.com/gilangarinata/
 */
class AlbumAdapter(val activity: Activity, val listener : AdapterCallback) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(private val itemAlbumBinding: ItemAlbumBinding) : RecyclerView.ViewHolder(itemAlbumBinding.root){
        fun bind(item : AlbumModel){
            itemAlbumBinding.ivAnimals.setImageDrawable(ContextCompat.getDrawable(activity, item.imageCoverId))
            itemAlbumBinding.root.setOnClickListener {
                listener.onItemSelected(item)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<AlbumModel>() {
        override fun areItemsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean {
            return oldItem.imageCoverId == newItem.imageCoverId
        }

        override fun areContentsTheSame(oldItem: AlbumModel, newItem: AlbumModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemBinding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlbumViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    
    interface AdapterCallback{
        fun onItemSelected(item : AlbumModel)
    }
}