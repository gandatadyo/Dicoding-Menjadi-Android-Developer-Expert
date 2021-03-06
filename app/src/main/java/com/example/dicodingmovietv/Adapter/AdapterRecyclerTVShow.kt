package com.example.dicodingmovietv.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dicodingmovietv.Activity.DetailActivity
import com.example.dicodingmovietv.Model.ParcelableData
import com.example.dicodingmovietv.R
import com.squareup.picasso.Picasso
import java.util.ArrayList

class AdapterRecyclerTVShow(private val listMovie: ArrayList<ParcelableData>) : RecyclerView.Adapter<AdapterRecyclerTVShow.CardViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_view, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(listMovie[position])
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: ParcelableData) {
            val txtName: TextView = itemView.findViewById(R.id.txt_name)
            val txtDescription: TextView = itemView.findViewById(R.id.txt_description)
            val imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
            txtName.text = movie.name
            txtDescription.text = movie.desc

            val imgurlsmall = "https://image.tmdb.org/t/p/w92/${movie.img}"
            Picasso.get().load(imgurlsmall).into(imgPhoto)

            itemView.setOnClickListener {
                val objIntent = Intent(itemView.context,
                    DetailActivity::class.java)
                objIntent.putExtra("mode","tvshow")
                objIntent.putExtra(DetailActivity.EXTRA_PERSON, movie)
                itemView.context.startActivity(objIntent)
            }
        }
    }

}