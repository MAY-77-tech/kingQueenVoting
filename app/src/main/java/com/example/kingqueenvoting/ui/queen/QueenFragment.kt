package com.example.kingqueenvoting.ui.queen

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kingqueenvoting.R
import com.example.kingqueenvoting.adapter.QueenAdapter
import kotlinx.android.synthetic.main.queen_home.*

class QueenFragment : Fragment() {

    private lateinit var viewModel: QueenViewModel
    private lateinit var adapter: QueenAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.queen_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = QueenAdapter()
        recQueenVoting.apply {
            adapter =adapter
            layoutManager = GridLayoutManager(context, 2,GridLayoutManager.VERTICAL,false)

            obserVM()
        }

    }

    fun obserVM(){
        viewModel = ViewModelProvider(this).get(QueenViewModel::class.java)

        viewModel.queenDetail.observe(viewLifecycleOwner, Observer {
            adapter.updateList(it)
        })
    }
}