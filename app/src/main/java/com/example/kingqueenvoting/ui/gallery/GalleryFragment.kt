package com.example.kingqueenvoting.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kingqueenvoting.R
import com.example.kingqueenvoting.adapter.KingAdapter
import com.example.kingqueenvoting.adapter.QueenAdapter
import com.example.kingqueenvoting.model.KingDetailsItem
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment(), KingAdapter.ClickerListener {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var kadapter: KingAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

return inflater.inflate(R.layout.fragment_gallery, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kadapter = KingAdapter()
        recKingVoting.apply {
            adapter =kadapter
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL,false)

        }
        obserVM()
    }

    fun obserVM(){
      galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        galleryViewModel.loadingK()
        galleryViewModel.getKn().observe(viewLifecycleOwner, Observer {
            kadapter.updateList(it)

            Log.d("updateList>>>>",it.toString())
            kadapter.setOnClickListener(this)

        })
    }

    override fun onClick(kingList: KingDetailsItem) {
        var action = GalleryFragmentDirections.actionNavGalleryToQueenFragment(
            kingList.id,
            kingList.name,
            kingList.vote_count,
            kingList.img_url,
            kingList.vote_time_status,
            kingList.`class`
        )
        findNavController().navigate(action)
    }
}