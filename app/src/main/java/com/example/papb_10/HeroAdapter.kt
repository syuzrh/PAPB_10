package com.example.papb_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.papb_10.databinding.ItemHeroBinding

typealias onClickHero = (Hero) -> Unit

class HeroAdapter (private val listHero: List<Hero>, private val onClickHero: onClickHero)
    : RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {
    inner class ItemHeroViewHolder(private  val binding: ItemHeroBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind (data: Hero){
            with(binding){
                txtHeroName.text = data.nameHero
                txtHeroType.text = data.typeHero
                imageHero.setImageResource(itemView.resources.getIdentifier(data.imageHero, "drawable", itemView.context.packageName))
                itemView.setOnClickListener{
                    onClickHero(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemHeroViewHolder {
        val binding = ItemHeroBinding.inflate(
            LayoutInflater.from(
            parent.context),parent,false)
        return ItemHeroViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }
}