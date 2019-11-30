package com.yuly.animator

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener(clickListener)

        iv_panda.setImageResource(R.drawable.progress_01)

    }


    private val clickListener: (View) -> Unit = l@{
        val count = Int.MAX_VALUE
        val animator = ObjectAnimator.ofFloat(iv_panda, "rotation", 0f, 360f * count)


//        animator.addUpdateListener {
//            val value = it.animatedValue as Float % 360
//            iv_panda.rotation = value
//        }
        animator.interpolator = LinearInterpolator()
//        valueAnimator.addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator?) {
//                super.onAnimationEnd(animation)
//                valueAnimator.setFloatValues(iv_panda.rotation, iv_panda.rotation + 30f)
//                valueAnimator.start()
//            }
//        })
        animator.duration = 1200L * count
//        valueAnimator.repeatCount = ValueAnimator.INFINITE
        animator.start()
    }
}
