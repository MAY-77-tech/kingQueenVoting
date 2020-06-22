package com.example.kingqueenvoting.model

import android.os.Parcel
import android.os.Parcelable

data class QueenDetailsItem(
    val `class`: String,
    val id: String,
    val img_url: String,
    val name: String,
    val vote_count: Int,
    val vote_time_status: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(`class`)
        parcel.writeString(id)
        parcel.writeString(img_url)
        parcel.writeString(name)
        parcel.writeInt(vote_count)
        parcel.writeInt(vote_time_status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QueenDetailsItem> {
        override fun createFromParcel(parcel: Parcel): QueenDetailsItem {
            return QueenDetailsItem(parcel)
        }

        override fun newArray(size: Int): Array<QueenDetailsItem?> {
            return arrayOfNulls(size)
        }
    }
}