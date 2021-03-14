package com.t3h.firstproject.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
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
        binding.btnTranslateProperties.setOnClickListener(this)
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
            R.id.btn_translate_properties->{
                val obX = ObjectAnimator.ofFloat(
                    binding.btnImg, "x",
                    0f, 500f, 200f, 700f,500f, 1000f
                )
                obX.setDuration(1000)

                val obY = ObjectAnimator.ofFloat(
                    binding.btnImg, "y",
                    0f, 500f, 200f, 700f,500f, 1000f
                )
                obY.setDuration(1000)

                val obAlpha = ObjectAnimator.ofFloat(
                    binding.btnImg, "alpha",
                    0f, 1.0f, 0.5f, 1.0f
                )
                obAlpha.setDuration(1000)

//                val obRotate = ObjectAnimator.ofFloat(
//                    binding.btnImg, "rotation",
//                    0f, 1.0f, 0.5f, 1.0f
//                )
//                obRotate.setDuration(1000)

                binding.btnImg.pivotX = binding.btnImg.width/2f
                binding.btnImg.pivotY = binding.btnImg.height/2f
                val obCustom = ObjectAnimator.ofFloat(
                    binding.btnImg, "testAhiHello",
                    0f, 360f, 180f, 270f,0f
                )
                obCustom.setDuration(1000)

                val set = AnimatorSet()
                set.setDuration(1000)
                set.playTogether(obX, obY, obAlpha, obCustom)
                set.start()


            }
        }
    }

}