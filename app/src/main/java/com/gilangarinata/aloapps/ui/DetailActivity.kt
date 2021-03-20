package com.gilangarinata.aloapps.ui

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.gilangarinata.aloapps.adapters.AdapterImageSlider
import com.gilangarinata.aloapps.databinding.ActivityDetailBinding
import com.gilangarinata.aloapps.models.AlbumModel
import com.gilangarinata.aloapps.ui.fragment.dataAlbum
import com.gilangarinata.aloapps.R

class DetailActivity : AppCompatActivity() {

    private var item : AlbumModel? = null
    private lateinit var binding : ActivityDetailBinding
    private lateinit var adapterImageSlider: AdapterImageSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleData()
        initAdapter()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        initViewPager()
    }

    private fun initToolbar(){
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initAdapter(){
        adapterImageSlider = AdapterImageSlider(this)
        item?.let { adapterImageSlider.setItems(items = it.imageCollection) }
    }

    private fun initViewPager(){
        binding.pager.adapter = adapterImageSlider
        binding.pager.currentItem = 0
        addBottomDots(binding.layoutDots, adapterImageSlider.count, 0)
        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageSelected(position: Int) {
                addBottomDots(binding.layoutDots, adapterImageSlider.count, position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

        })
    }

    private fun addBottomDots(layoutDots: LinearLayout, size: Int, current: Int) {
        val dots = arrayOfNulls<ImageView>(size)
        layoutDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(this)
            val widthHeight = 15
            val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams(widthHeight, widthHeight))
            params.setMargins(10, 10, 10, 10)
            dots[i]!!.layoutParams = params
            dots[i]!!.setImageResource(R.drawable.shape_circle)
            dots[i]!!
                .setColorFilter(
                    ContextCompat.getColor(this, R.color.overlay_dark_10),
                    PorterDuff.Mode.SRC_ATOP
                )
            layoutDots.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[current]!!
                .setColorFilter(
                    ContextCompat.getColor(this, R.color.teal_200),
                    PorterDuff.Mode.SRC_ATOP
                )
        }
    }

    private fun getBundleData(){
        item = intent.getParcelableExtra(dataAlbum)
    }

}