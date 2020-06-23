package com.example.kingqueenvoting.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingqueenvoting.R
import com.example.kingqueenvoting.model.KingDetailsItem
import com.example.kingqueenvoting.model.QueenDetailsItem
import com.example.kingqueenvoting.ui.gallery.GalleryFragment
import com.example.kingqueenvoting.ui.home.HomeFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.king_item.view.*
import kotlinx.android.synthetic.main.queen_item.view.*

class KingAdapter(var kingList: List<KingDetailsItem> = ArrayList()): RecyclerView.Adapter<KingAdapter.KingViewHolder>()  {
    private var clickListener: ClickerListener? = null
    fun setOnClickListener(clickListener: GalleryFragment) {
        this.clickListener = clickListener
    }
    inner class KingViewHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener{
        private lateinit var kingDetails: KingDetailsItem

        fun kingBbind(kingDetails: KingDetailsItem){
            this.kingDetails = kingDetails
            Picasso.get()
                .load(kingDetails.img_url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.king_image)
            itemView.king_name.text = kingDetails.name
            itemView.king_id.text = kingDetails.id

            Log.d("Id>>>>>>",kingDetails.id)
        }

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            clickListener?.onClick(kingDetails)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        var myview = LayoutInflater.from(parent.context).inflate(R.layout.king_item,parent,false)
        return KingViewHolder(myview)
    }

    override fun getItemCount(): Int {
        return kingList.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.kingBbind(kingList[position])
    }

    fun updateList (kingList: List<KingDetailsItem>){
        this.kingList = kingList
        notifyDataSetChanged()
    }

    interface ClickerListener {
        fun onClick(kingList: KingDetailsItem)
    }
}