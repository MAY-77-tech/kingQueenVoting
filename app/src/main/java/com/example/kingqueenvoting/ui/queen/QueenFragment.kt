package com.example.kingqueenvoting.ui.queen

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.kingqueenvoting.R
import com.example.kingqueenvoting.api.QueenApi
import com.example.kingqueenvoting.model.QueenVote
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.queen_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QueenFragment : Fragment() {

    private var api = QueenApi()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.queen_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data = arguments.let { QueenFragmentArgs.fromBundle(it!!) }
        txtId.text = data.id
        txtName.text = data.name
        txtCount.text = data.voteCount.toString()

        Picasso.get()
            .load(data.imgUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(profile_img)
        txtTime.text = data.voteTimeStatus.toString()
        txtClass.text = data.Class

        btnAdd.setOnClickListener {
            var code = edtCode.text.toString()

            if (TextUtils.isEmpty(code)) {
                edtCode.setError("Require")
            }
            if (!code.isEmpty()) {
                voteQueen(code,data.id)
            }

        }

    }
    private fun voteQueen(code: String, id: String) {
        var apiCall = api.queenVote(code, id)

        Log.d("code>>>>",code)
        Log.d("ResultID>>>>>>",id)

        apiCall.enqueue(object : Callback<QueenVote> {
            override fun onFailure(call: Call<QueenVote>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<QueenVote>, response: Response<QueenVote>) {
                Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()
            }
        })
    }


}