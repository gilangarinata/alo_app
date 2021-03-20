package com.gilangarinata.aloapps.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumModel(
    val imageCoverId: Int,
    val imageCollection : List<Images>
) : Parcelable

@Parcelize
data class Images(
    val imageId : Int
) : Parcelable