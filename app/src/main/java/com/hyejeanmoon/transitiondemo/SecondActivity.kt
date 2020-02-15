package com.hyejeanmoon.transitiondemo

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.Window

class SecondActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        window.sharedElementEnterTransition = ChangeBounds()
        window.sharedElementExitTransition = ChangeBounds()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        title = "SecondActivity"
    }
}
