package com.example.kingqueenvoting.api

import com.example.kingqueenvoting.model.KingDetails
import com.example.kingqueenvoting.model.KingVote
import com.example.kingqueenvoting.model.QueenDetails
import com.example.kingqueenvoting.model.QueenVote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface QueenApiInterface {

    @GET("queen")
    fun getQueen():Call<QueenDetails>

    @POST("queenvote")
    fun queenvote(
        @Query("code")code:String,
        @Query("queen_id")queenId: String
    ):Call<QueenVote>

    @GET("king")
    fun getKing():Call<KingDetails>

    @POST("kingvote")
    fun kingVote(
        @Query("code")code:String,
        @Query("king_id")kingId: String
    ):Call<KingVote>

}