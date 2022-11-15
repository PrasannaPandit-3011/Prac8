package com.example.prac8

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.prac8.R

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var guni_image: ImageView
    lateinit var logo_framebyframeanimation: AnimationDrawable
    lateinit var twinanimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        guni_image=findViewById(R.id.img)
        guni_image.setBackgroundResource(R.drawable.uvpce_logo_list)
        logo_framebyframeanimation=guni_image.background as AnimationDrawable
        twinanimation = AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twinanimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus)
        {
            logo_framebyframeanimation.start()
            guni_image.startAnimation(twinanimation)
        }
        else
        {
            logo_framebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also{startActivity(it)}
        overridePendingTransition(R.anim.scale_center_in, R.anim.scale_center_out)
        finish()
    }
}