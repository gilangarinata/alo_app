package com.gilangarinata.aloapps.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gilangarinata.aloapps.R
import com.gilangarinata.aloapps.models.Images


/**
 * Created by Gilang Arinata on 20/03/21.
 * https://github.com/gilangarinata/
 */
class AdapterImageSlider(private val activity: Activity) : PagerAdapter() {

    private var items : MutableList<Images> = mutableListOf()

    override fun getCount(): Int {
        return items.size
    }

    fun setItems(items: List<Images>) {
        if(this.items.isNotEmpty()) this.items.clear()
        this.items = items as MutableList<Images>
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val item = items[position]
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_slider_image, container, false)
        val image = view.findViewById<View>(R.id.image) as ImageView
        image.setImageDrawable(ContextCompat.getDrawable(activity, item.imageId))
        (container as ViewPager).addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as RelativeLayout)
    }
}