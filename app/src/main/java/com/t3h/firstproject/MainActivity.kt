package com.t3h.firstproject

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_shape)
        val iv = findViewById<ImageView>(R.id.iv_animation)
        val ani = iv.drawable as AnimationDrawable
        ani.start()

        val btnClick = findViewById<Button>(R.id.btn_click)
        btnClick.setOnClickListener(this)
        iv.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_click->{
                //dung Intent
                val intent = Intent()
                intent.setAction(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application"))
                startActivity(intent)
            }
            R.id.iv_animation->{
                val intent = Intent()
                intent.setClass(this, DemoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}