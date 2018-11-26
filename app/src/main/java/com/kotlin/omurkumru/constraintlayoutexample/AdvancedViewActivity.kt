package com.kotlin.omurkumru.constraintlayoutexample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator

class AdvancedViewActivity : AppCompatActivity() {

    lateinit var layout: ConstraintLayout
    var constraintSetOld = ConstraintSet()
    var constraintSetNew = ConstraintSet()

    var altLayout: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_view)

        layout = findViewById(R.id.newConstraint)

        constraintSetOld.clone(layout)
        constraintSetNew.clone(this,R.layout.activity_advanced_alt)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun swapView(view: View){
        //var changeBounds: Transition = ChangeBounds()
        //changeBounds.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(layout)

        if (!altLayout){
            constraintSetNew.applyTo(layout)
            altLayout = true
        }else{
            constraintSetOld.applyTo(layout)
            altLayout = false
        }



    }
}
