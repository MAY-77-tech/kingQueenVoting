package com.example.kingqueenvoting.api

import com.example.kingqueenvoting.model.QueenDetails
import retrofit2.Call
import retrofit2.http.GET

interface QueenApiInterface {

    @GET("queen")
    fun getQueen():Call<QueenDetails>

}