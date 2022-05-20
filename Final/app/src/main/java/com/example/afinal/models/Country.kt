package com.example.afinal.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Country(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @ColumnInfo(name = "Country", index = true) var Country: String? = null,
    @ColumnInfo(name = "Slug") var Slug: String? = null,
    @ColumnInfo(name = "ISO2") var ISO2: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(Country)
        parcel.writeString(Slug)
        parcel.writeString(ISO2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Country> {
        override fun createFromParcel(parcel: Parcel): Country {
            return Country(parcel)
        }

        override fun newArray(size: Int): Array<Country?> {
            return arrayOfNulls(size)
        }
    }

}