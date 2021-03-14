package com.t3h.firstproject.customview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView

class MyImageView : AppCompatImageView {
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setTestAhiHello(value: Float) {
        Log.d("MyImageView", "setTestAhiHello value: " + value)
//        rotationX = value
//        rotationY = value
        rotation = value
    }
}