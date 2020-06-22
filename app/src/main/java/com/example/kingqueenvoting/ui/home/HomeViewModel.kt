package com.example.kingqueenvoting.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kingqueenvoting.api.QueenApi
import com.example.kingqueenvoting.model.QueenDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    var queenDetail: MutableLiveData<QueenDetails> = MutableLiveData()

    fun getQn():MutableLiveData<QueenDetails> = queenDetail

    var qnApi = QueenApi()

    fun loadingQn(){

        var quApiCall = qnApi.getQueen()

        quApiCall.enqueue(object : Callback<QueenDetails> {
            override fun onFailure(call: Call<QueenDetails>, t: Throwable) {
                Log.d("Error", t.toString())
            }

            override fun onResponse(call: Call<QueenDetails>, response: Response<QueenDetails>) {

                var movieList = response.body()
                queenDetail.value = movieList
            }
        })
    }
}