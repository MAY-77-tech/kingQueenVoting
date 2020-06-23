package com.example.kingqueenvoting.api

import com.example.kingqueenvoting.model.KingDetails
import com.example.kingqueenvoting.model.KingVote
import com.example.kingqueenvoting.model.QueenDetails
import com.example.kingqueenvoting.model.QueenVote
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
    fun queenVote(code:String,queenId:String):Call<QueenVote> {
        return queenApiInterface.queenvote(code, queenId)
    }

    fun getKing():Call<KingDetails> = queenApiInterface.getKing()
    fun kingVote(code:String,kingId:String):Call<KingVote> {
        return queenApiInterface.kingVote(code, kingId)
    }

}