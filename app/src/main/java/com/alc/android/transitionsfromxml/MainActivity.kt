package com.alc.android.transitionsfromxml

import android.os.Build
import android.os.Bundle

import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private lateinit var scene1: Scene
	private lateinit var scene2: Scene
	private lateinit var currentScene: Scene
	private lateinit var transition: Transition

	@RequiresApi(Build.VERSION_CODES.KITKAT)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// Step 1: Create a Scene object for both the starting and ending layout
		scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this)
		scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this)

		// Step 2: Create a Transition object to define what type of animation you want
		transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2)

		scene1.enter()
		currentScene = scene1
	}

	@RequiresApi(Build.VERSION_CODES.KITKAT)
	fun onClick(view: View) {
		// Step 3: Call TransitionManager.go() to run animation

		currentScene = if (currentScene === scene1) {
			TransitionManager.go(scene2, transition)
			scene2
		} else {
			TransitionManager.go(scene1, transition)
			scene1
		}
		
	}
}
