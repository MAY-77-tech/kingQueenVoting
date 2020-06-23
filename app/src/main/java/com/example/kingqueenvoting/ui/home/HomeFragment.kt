package com.example.kingqueenvoting.ui.home

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
import com.example.kingqueenvoting.adapter.QueenAdapter
import com.example.kingqueenvoting.model.QueenDetailsItem
import kotlinx.android.synthetic.main.queen_home.*

class HomeFragment : Fragment(),QueenAdapter.ClickerListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var qadapter: QueenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        qadapter = QueenAdapter()
        recQueenVoting.apply {
            adapter =qadapter
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL,false)

        }
        obserVM()
    }

    fun obserVM(){
       homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.loadingQn()
        homeViewModel.getQn().observe(viewLifecycleOwner, Observer {
            qadapter.updateList(it)

            Log.d("updateList>>>>",it.toString())
            qadapter.setOnClickListener(this)

        })
    }

    override fun onClick(queenList: QueenDetailsItem) {
            var action = HomeFragmentDirections.actionNavHomeToQueenFragment(
                queenList.id,
                queenList.name,
                queenList.vote_count,
                queenList.img_url,
               queenList.vote_time_status,
                queenList.`class`
            )
            findNavController().navigate(action)
    }
}
