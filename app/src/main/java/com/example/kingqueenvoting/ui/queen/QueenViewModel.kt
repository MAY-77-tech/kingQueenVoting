package com.example.kingqueenvoting.ui.queen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kingqueenvoting.api.QueenApi
import com.example.kingqueenvoting.model.QueenDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenViewModel : ViewModel() {

    var queenDetail: MutableLiveData<QueenDetails> = MutableLiveData()

    fun getMD(): MutableLiveData<QueenDetails> = queenDetail

    var qApi = QueenApi()

    fun qLoading(id: Int, apiKey: String){

        var qApiCall = qApi.getQueen()

        qApiCall.enqueue(object :Callback<QueenDetails>{
            override fun onFailure(call: Call<QueenDetails>, t: Throwable) {

            }

            override fun onResponse(call: Call<QueenDetails>, response: Response<QueenDetails>) {
                var queenList = response.body()
                Log.d("queenList",queenList.toString())
                queenDetail.value = queenList
                Log.d("Response", response.body().toString())
            }

        })
    }
}