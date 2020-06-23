package com.example.kingqueenvoting.ui.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kingqueenvoting.api.QueenApi
import com.example.kingqueenvoting.model.KingDetails
import com.example.kingqueenvoting.model.QueenDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryViewModel : ViewModel() {
        var kingDetail: MutableLiveData<KingDetails> = MutableLiveData()

        fun getKn():MutableLiveData<KingDetails> = kingDetail

        var KApi = QueenApi()

        fun loadingK(){

            var quApiCall = KApi.getKing()

            quApiCall.enqueue(object : Callback<KingDetails> {
                override fun onFailure(call: Call<KingDetails>, t: Throwable) {
                    Log.d("Error", t.toString())
                }

                override fun onResponse(call: Call<KingDetails>, response: Response<KingDetails>) {

                    var kingDetails = response.body()
                   kingDetail.value = kingDetails

                    Log.d("QueenDetailList>>>>>",kingDetails.toString())
                }
            })
        }
}