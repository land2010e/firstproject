package com.t3h.firstproject;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusCircleImageView extends
        CircleImageView {
    private int colorStatus = Color.BLUE;
    private int radiusSatus = 100;
    public StatusCircleImageView(Context context) {
        super(context);
    }

    public StatusCircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAllAttr(attrs);
    }

    public StatusCircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        getAllAttr(attrs);
    }

    private void getAllAttr(AttributeSet attr){
        //lay cac thuoc tinh ma xml da dinh nghia
        TypedArray type = getContext().obtainStyledAttributes(
                attr,
                R.styleable.StatusCircleImageViewKotlin);
        colorStatus = type.getColor(
                R.styleable.StatusCircleImageViewKotlin_colorStatus,
                Color.BLUE);
        radiusSatus = type.getDimensionPixelOffset(
                R.styleable.StatusCircleImageViewKotlin_radiusSatus,
                100);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.parseColor("#4CAF50"));
        paint.setColor(colorStatus);
        double x = getWidth()/2*(1+Math.sqrt(2.0f)/2);
        double y = getHeight()/2*(1+Math.sqrt(2.0f)/2);
        canvas.drawCircle(
                (float) x, (float)y,
                radiusSatus,
                paint
        );
    }
}
