package com.t3h.firstproject.animation

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.t3h.firstproject.R
import com.t3h.firstproject.databinding.DemoAnimationBinding

class AnimationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: DemoAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.demo_animation
        )
        binding.btnTranslate.setOnClickListener(this)
        binding.btnRotate.setOnClickListener(this)
        binding.btnAlpha.setOnClickListener(this)
        binding.btnSet.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_translate -> {
                val ani = AnimationUtils.loadAnimation(this,
                    R.anim.demo_translate)
                binding.btnImg.animation =ani
                binding.btnImg.startAnimation(ani)
            }
            R.id.btn_rotate->{
                val ani = AnimationUtils.loadAnimation(this,
                    R.anim.demo_rotate)
                binding.btnImg.animation =ani
                binding.btnImg.startAnimation(ani)
            }
            R.id.btn_alpha->{
                val ani = AnimationUtils.loadAnimation(this,
                    R.anim.demo_alpha)
                binding.btnImg.animation =ani
                binding.btnImg.startAnimation(ani)
            }
            R.id.btn_set->{
                val ani = AnimationUtils.loadAnimation(this,
                    R.anim.demo_set)
                binding.btnImg.animation =ani
                binding.btnImg.startAnimation(ani)

                //bat su kien aniimation
                ani.setAnimationListener(object : Animation.AnimationListener{
                    override fun onAnimationRepeat(animation: Animation?) {

                    }

                    override fun onAnimationEnd(animation: Animation?) {
                        val anii = AnimationUtils.loadAnimation(baseContext,
                            R.anim.demo_alpha)
                        binding.btnImg.animation =anii
                        binding.btnImg.startAnimation(anii)
                    }

                    override fun onAnimationStart(animation: Animation?) {

                    }
                })
            }
        }
    }

}