package com.uilover.project2192.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uilover.project2192.Activity.DetailActivity
import com.uilover.project2192.Model.ItemsModel
import com.uilover.project2192.databinding.ViewholderBestSellerBinding

class BestSellerAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<BestSellerAdapter.Viewholder>() {
    class Viewholder(val binding: ViewholderBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.Viewholder {
        val binding =
            ViewholderBestSellerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text=items[position].title
        holder.binding.priceTxt.text=items[position].price.toString()+" USD"
        holder.binding.ratingBar.rating=items[position].rating.toFloat()

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)

        Glide.with(holder.itemView.context)
            .load(items[position].logo)
            .into(holder.binding.logo)

        holder.itemView.setOnClickListener {
            val intent=Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("object",items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int =items.size
}