package com.example.kingqueenvoting.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kingqueenvoting.R
import com.example.kingqueenvoting.model.QueenDetailsItem
import com.example.kingqueenvoting.ui.gallery.GalleryFragment
import com.example.kingqueenvoting.ui.home.HomeFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.queen_item.view.*

class QueenAdapter(var queenList: List<QueenDetailsItem> = ArrayList()): RecyclerView.Adapter<QueenAdapter.QueenViewHolder>() {

    private var clickListener: ClickerListener? = null
    fun setOnClickListener(clickListener: HomeFragment) {
        this.clickListener = clickListener
    }
    inner class QueenViewHolder(item: View) : RecyclerView.ViewHolder(item),View.OnClickListener{
        private lateinit var queenDetails: QueenDetailsItem

        fun queenBbind(queenDetails: QueenDetailsItem){
            this.queenDetails = queenDetails
            Picasso.get()
                .load(queenDetails.img_url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.queen_image)
            itemView.queen_name.text = queenDetails.name
            itemView.queen_id.text = queenDetails.id

            Log.d("Id>>>>>>",queenDetails.id)
        }

        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            clickListener?.onClick(queenDetails)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var myview = LayoutInflater.from(parent.context).inflate(R.layout.queen_item,parent,false)
        return QueenViewHolder(myview)
    }

    override fun getItemCount(): Int {
        return queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.queenBbind(queenList[position])
    }

    fun updateList (queenList: List<QueenDetailsItem>){
        this.queenList = queenList
        notifyDataSetChanged()
    }

    interface ClickerListener {
        fun onClick(queenList: QueenDetailsItem)
    }
}