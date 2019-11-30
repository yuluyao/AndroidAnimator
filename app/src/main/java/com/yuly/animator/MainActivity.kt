package com.yuly.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener(clickListener)

        iv_panda.setImageResource(R.drawable.progress_01)

    }


    private val clickListener: (View) -> Unit = l@{
    val valueAnimator = ValueAnimator.ofFloat(iv_panda.rotation, iv_panda.rotation + 30f)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            iv_panda.rotation = value
        }
        valueAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                valueAnimator.setFloatValues(iv_panda.rotation, iv_panda.rotation + 30f)
                valueAnimator.start()
            }
        })
        valueAnimator.duration = 200
//        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.start()
    }
}
