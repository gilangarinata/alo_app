package com.gilangarinata.aloapps.tools

import android.annotation.SuppressLint
import android.content.Context
import com.gilangarinata.aloapps.R
import com.gilangarinata.aloapps.models.AlbumModel
import com.gilangarinata.aloapps.models.Images
import java.util.*


/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class DataGenerator {
    @SuppressLint("Recycle")
    fun getImageDate(ctx: Context): List<AlbumModel> {
        val albumModels : MutableList<AlbumModel> = mutableListOf()

        val imageCats = ctx.resources.obtainTypedArray(R.array.sample_images_cat)
        val imageTigers = ctx.resources.obtainTypedArray(R.array.sample_images_tiger)
        val imageEagles = ctx.resources.obtainTypedArray(R.array.sample_images_eagle)
        val imageBears = ctx.resources.obtainTypedArray(R.array.sample_images_bear)

        val imageCatCover = imageCats.getResourceId(0,-1)
        val imageTigerCover = imageTigers.getResourceId(0, -1)
        val imageEagleCover = imageEagles.getResourceId(0,-1)
        val imageBearCover = imageBears.getResourceId(0,-1)

        val imageCatCollections : MutableList<Images> = mutableListOf()
        val imageTigerCollections : MutableList<Images> = mutableListOf()
        val imageEagleCollections : MutableList<Images> = mutableListOf()
        val imageBearCollections : MutableList<Images> = mutableListOf()

        for (i in 0 until imageCats.length()) {
            val image = Images(imageId = imageCats.getResourceId(i,-1))
            imageCatCollections.add(image)
        }

        for (i in 0 until imageTigers.length()) {
            val image = Images(imageId = imageTigers.getResourceId(i,-1))
            imageTigerCollections.add(image)
        }

        for (i in 0 until imageEagles.length()) {
            val image = Images(imageId = imageEagles.getResourceId(i,-1))
            imageEagleCollections.add(image)
        }

        for (i in 0 until imageBears.length()) {
            val image = Images(imageId = imageBears.getResourceId(i,-1))
            imageBearCollections.add(image)
        }

        val albumModel1 = AlbumModel(imageCatCover, imageCatCollections)
        val albumModel2 = AlbumModel(imageTigerCover, imageTigerCollections)
        val albumModel3 = AlbumModel(imageEagleCover, imageEagleCollections)
        val albumModel4 = AlbumModel(imageBearCover, imageBearCollections)
        albumModels.add(albumModel1)
        albumModels.add(albumModel2)
        albumModels.add(albumModel3)
        albumModels.add(albumModel4)
        return albumModels
    }
}