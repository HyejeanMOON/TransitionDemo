package com.hyejeanmoon.transitiondemo

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.ChangeBounds
import android.util.Pair
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : BaseActivity() {

    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        setThisUpWindow()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.txt)
        btn1 = findViewById(R.id.btn1)
        val imgView = findViewById<ImageView>(R.id.img)


        btn1.setOnClickListener {
            val intent = Intent()
            val pair1 = Pair(imgView as View, imgView.transitionName)
            val pair2 = Pair(textView as View, textView.transitionName)
            intent.setClass(this, SecondActivity::class.java)
            val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this@MainActivity,
                pair1, pair2
            )
            startActivity(intent, transitionActivityOptions.toBundle())
        }

    }

    private fun setThisUpWindow() {
        window.sharedElementEnterTransition = ChangeBounds()
        window.sharedElementExitTransition = ChangeBounds()
    }
}
