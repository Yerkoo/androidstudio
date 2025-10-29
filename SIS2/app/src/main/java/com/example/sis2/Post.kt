package com.example.sis2
import android.os.Parcel
import android.os.Parcelable
data class Post (
    val id: Int,
    val text: String,
    val imageUrl: String,
    var isLiked:Boolean = false
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(text)
        parcel.writeString(imageUrl)
        parcel.writeByte(if (isLiked) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post = Post(parcel)
        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }
}