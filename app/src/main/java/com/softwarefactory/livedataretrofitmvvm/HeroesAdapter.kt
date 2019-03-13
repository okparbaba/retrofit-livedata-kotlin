package com.softwarefactory.livedataretrofitmvvm
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HeroesAdapter(private var mCtx: Context, private var heroList: List<Hero>) :
    RecyclerView.Adapter<HeroesAdapter.HeroViewHolder>() {
    override fun getItemCount(): Int {
        return heroList.size
    }


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_view_layout, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder( holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]

        Glide.with(mCtx)
            .load(hero.imageurl)
            .into(holder.imageView)

        holder.textView.text = hero.name
    }

    inner class HeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var textView: TextView

        init {

            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
        }
    }
}