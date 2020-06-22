package com.example.kingqueenvoting.api

import com.example.kingqueenvoting.model.QueenDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QueenApi {

    private val queenApiInterface: QueenApiInterface

    companion object {
        val BASE_URL = "https://ucsmonywaonlinevote.000webhostapp.com/api/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
       queenApiInterface = retrofit.create(QueenApiInterface::class.java)
    }

    fun getQueen():Call<QueenDetails> = queenApiInterface.getQueen()

}