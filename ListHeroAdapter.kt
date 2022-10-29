package com.example.praktikum.day3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikum.databinding.ItemRowHeroBinding
import com.example.praktikum.day3.model.Hero


class ListHeroAdapter : RecyclerView.Adapter<ListHeroAdapter.ListHeroViewHolder>() {

    private val heroes = mutablelistof<Hero>()
    private var listener: Itemlistener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListHeroViewHolder {
        val binding = ItemRowHeroBinding.inflate(
            layoutInflater.from(parent.context),
            parent,
            attachToParent:false)
        return ListHeroViewHolder(binding)
    }

    override fun onCreateViewHolder(holder: ListHeroViewHolder, position: int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int = heroes.size

    fun submitlist(list: List<Hero>) {
        heroes.clear()
        heroes.addALL(list)
        notifyDataSetChanged()
    }

    inner class ListHeroViewHolder(private val binding: ItemRowHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Hero): {
            binding.tvItemName.text = data.name
            binding.tvItemDescription.text = data.description
            binding.tvItemPhoto.setImageResource = data.photo
            itemView.setOnContextClickListener { listener?.onClick(data) }
        }
    }

    interface Itemlistener {
        fun onClick(data: Hero)
    }
}


