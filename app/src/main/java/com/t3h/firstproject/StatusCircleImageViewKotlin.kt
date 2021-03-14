package com.t3h.firstproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Handler
import android.util.AttributeSet
import de.hdodenhof.circleimageview.CircleImageView
import java.util.jar.Attributes

//class StatusCircleImageViewKotlin(context:Context) :
//    CircleImageView(context){
class StatusCircleImageViewKotlin :
    CircleImageView {
    private var colorStatus = Color.BLUE
    private var radiusStatus = 100
    private var isActive = false

    constructor(context: Context) : super(context) {
        //content need to override
    }

    constructor(context: Context, attr: AttributeSet) :
            super(context, attr) {
        //content need to override
        getAllAttr(attr)
    }

    constructor(context: Context, attr: AttributeSet, type: Int) :
            super(context, attr, type) {
        //content need to override
        getAllAttr(attr)
    }




    private fun getAllAttr(attr: AttributeSet) {
       val type = context.obtainStyledAttributes(
            attr,
            R.styleable.StatusCircleImageViewKotlin
        )
        colorStatus = type.getColor(
            R.styleable.StatusCircleImageViewKotlin_colorStatus,
            Color.BLUE
        )
        radiusStatus = type.getDimensionPixelOffset(
            R.styleable.StatusCircleImageViewKotlin_radiusSatus,
            100
        )
        isActive = type.getBoolean(
            R.styleable.StatusCircleImageViewKotlin_isActive,
            false
        )


    }

    fun setActive(isActive:Boolean){
        this.isActive=isActive
        //khi goi huong thuc nay thi sex goi on draw
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
//        paint.setColor(Color.parseColor("#4CAF50"))
        if (isActive){
            paint.setColor(colorStatus)
            paint.style = Paint.Style.FILL
            val x = width / 2 * (1 + Math.sqrt(2.0) / 2)
            val y = height / 2 * (1 + Math.sqrt(2.0) / 2)
            canvas?.drawCircle(
                x.toFloat(),
                y.toFloat(),
                radiusStatus.toFloat(), paint
            )
        }

    }


}