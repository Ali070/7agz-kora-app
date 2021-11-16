package com.alisamir.a7agzkora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import com.alisamir.a7agzkora.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val firstAnim = AnimationUtils.loadAnimation(this,R.anim.splash_back)
        val secondAnim = AnimationUtils.loadAnimation(this,R.anim.splash_text)
        binding.messageTV.startAnimation(secondAnim)
        binding.messgae2TV.startAnimation(secondAnim)
        secondAnim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.splashLayout.startAnimation(firstAnim)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }

        })

                Handler().postDelayed({
                    startActivity(Intent(this@SplashScreen,MainActivity::class.java))
                    finish()
                },3000)

    }
}