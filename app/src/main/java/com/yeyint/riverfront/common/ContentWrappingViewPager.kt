package com.yeyint.riverfront.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager


class ContentWrappingViewPager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {
    private var mWidth = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var mHeightMeasureSpec = heightMeasureSpec
        var height = 0
        mWidth = widthMeasureSpec
        if (childCount > currentItem) {
            val child: View = getChildAt(currentItem)
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val h: Int = child.measuredHeight
            if (h > height) height = h
        }
        mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, mHeightMeasureSpec)
    }

    fun onRefresh() {
        try {
            var height = 0
            if (childCount > currentItem) {
                val child = getChildAt(currentItem)
                child.measure(mWidth, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
                val h = child.measuredHeight
                if (h > height) height = h
            }
            val heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
            val layoutParams = this.layoutParams
            layoutParams.height = heightMeasureSpec
            setLayoutParams(layoutParams)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}