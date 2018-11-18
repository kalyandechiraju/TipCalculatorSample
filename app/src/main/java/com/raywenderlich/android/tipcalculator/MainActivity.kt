package com.raywenderlich.android.tipcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainActivityViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // TODO Instantiate ViewModel

    setupView()
  }

  private fun setupView() {
    // TODO setup your view here
  }

  override fun onResume() {
    super.onResume()
    // TODO update view on state emitted by viewmodel
  }
}
