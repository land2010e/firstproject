package com.t3h.firstproject

import android.content.Context
import android.graphics.*
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class ClockView : View, Runnable {
    private var colorBorder = Color.BLACK
    private var colorFont = Color.BLACK
    private var sizeBorder = 20
    private var timePadding = 40
    private var datePadding = 100
    private var fontSizeTime = 50
    private var fontSizeDate = 50
    private var facePadding = 225
    private var handlerTime = Handler()
    private var imageFace: Bitmap? = null

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        getAllAttr(attrs!!)
        inits()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        getAllAttr(attrs!!)
        inits()
    }

    private fun inits() {
        handlerTime.postDelayed(this, 1000)
    }

    override fun run() {
        invalidate()
        handlerTime.postDelayed(this, 1000)
    }

    override fun onDetachedFromWindow() {
        handlerTime.removeCallbacks(this)
        super.onDetachedFromWindow()
    }

    private fun getAllAttr(attrs: AttributeSet) {
        val type = context.obtainStyledAttributes(
            attrs,
            R.styleable.ClockView
        )
        colorBorder = type.getColor(
            R.styleable.ClockView_colorBorder,
            Color.BLUE
        )
        colorFont = type.getColor(
            R.styleable.ClockView_colorFont,
            Color.BLUE
        )
        sizeBorder = type.getDimensionPixelSize(
            R.styleable.ClockView_sizeBorder,
            20
        )
        timePadding = type.getDimensionPixelSize(
            R.styleable.ClockView_timePadding,
            20
        )
        datePadding = type.getDimensionPixelSize(
            R.styleable.ClockView_datePadding,
            20
        )
        fontSizeDate = type.getDimensionPixelSize(
            R.styleable.ClockView_fontSizeDate,
            20
        )
        fontSizeTime = type.getDimensionPixelSize(
            R.styleable.ClockView_fontSizeTime,
            20
        )
        facePadding = type.getDimensionPixelSize(
            R.styleable.ClockView_facePadding,
            250
        )
        val imageFaceRe = type.getResourceId(
            R.styleable.ClockView_imageFace,
            R.drawable.smile_4
        )
        imageFace = BitmapFactory.decodeResource(
            context.resources, imageFaceRe
        )
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBorder(canvas)
        drawTime(canvas)
        drawImageFace(canvas)
    }

    private fun drawImageFace(canvas: Canvas?) {
        if (imageFace == null) {
            return
        }
        canvas?.drawBitmap(
            imageFace!!,
            (width - imageFace!!.width.toFloat()) / 2,
            facePadding.toFloat(),
            null
        )
    }


    private fun drawTime(canvas: Canvas?) {
        val currentTime = Date()
        val formatTime = SimpleDateFormat("HH:mm:ss")
        val time = formatTime.format(currentTime)
        val formatDate = SimpleDateFormat("DD/MM/YY")
        val date = formatDate.format(currentTime)

        var p = Paint()
        p.textSize = fontSizeTime.toFloat()
        p.setColor(colorFont)
        //lay kich thuoc cua text
        val rectTime = Rect()
        p.getTextBounds(time, 0, time.length, rectTime)
        var x = (width - rectTime.width()) / 2
        canvas?.drawText(time, x.toFloat(), timePadding.toFloat(), p)

        p = Paint()
        p.textSize = fontSizeDate.toFloat()
        p.setColor(colorFont)
        p.getTextBounds(date, 0, date.length, rectTime)
        x = (width - rectTime.width()) / 2
        canvas?.drawText(date, x.toFloat(), datePadding.toFloat(), p)
    }

    private fun drawBorder(canvas: Canvas?) {
        val pBorder = Paint()
        pBorder.style = Paint.Style.STROKE
        pBorder.setColor(colorBorder)
        pBorder.strokeWidth = sizeBorder.toFloat()
        val minSize = Math.min(width, height)
        canvas?.drawCircle(
            width.toFloat() / 2,
            height.toFloat() / 2,
            minSize.toFloat() / 2 - sizeBorder / 2,
            pBorder
        )
    }
}