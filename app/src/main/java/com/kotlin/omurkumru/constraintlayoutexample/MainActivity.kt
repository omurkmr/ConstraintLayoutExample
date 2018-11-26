package com.kotlin.omurkumru.constraintlayoutexample

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.constraint.Placeholder
import android.transition.TransitionManager
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var placeHolder :Placeholder
    lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        placeHolder = findViewById(R.id.placeholder)
        constraintLayout = findViewById(R.id.constraintlayout)
    }


    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun swapView(view : View){
        TransitionManager.beginDelayedTransition(constraintLayout)
        placeHolder.setContentId(view.id)
    }

    fun openOtherActivity(view: View){
        val intent = Intent(this, AdvancedViewActivity::class.java)
        startActivity(intent)
    }
}
