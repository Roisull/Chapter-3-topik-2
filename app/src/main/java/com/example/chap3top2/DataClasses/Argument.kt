package com.example.chap3top2.DataClasses

import android.os.Parcel
import android.os.Parcelable

data class Argument(val argumentSatu: String?, val argumentDua: String?): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(argumentSatu)
        parcel.writeString(argumentDua)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Argument> {
        override fun createFromParcel(parcel: Parcel): Argument {
            return Argument(parcel)
        }

        override fun newArray(size: Int): Array<Argument?> {
            return arrayOfNulls(size)
        }
    }
}