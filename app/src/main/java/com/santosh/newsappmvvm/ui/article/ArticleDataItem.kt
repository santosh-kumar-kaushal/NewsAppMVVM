package com.santosh.newsappmvvm.ui.article

import android.os.Parcel
import android.os.Parcelable

class ArticleDataItem(
    val author: String?,
    val imageUrl: String?,
    val title: String?,
    val publishedDate: String?,
    val content: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(imageUrl)
        parcel.writeString(title)
        parcel.writeString(publishedDate)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleDataItem> {
        override fun createFromParcel(parcel: Parcel): ArticleDataItem {
            return ArticleDataItem(parcel)
        }

        override fun newArray(size: Int): Array<ArticleDataItem?> {
            return arrayOfNulls(size)
        }
    }
}