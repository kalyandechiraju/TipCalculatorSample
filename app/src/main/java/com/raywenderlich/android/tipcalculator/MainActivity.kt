package com.raywenderlich.android.tipcalculator

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainActivityViewModel

  private lateinit var resultTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Instantiate ViewModel
    viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

    setupView()
  }

  private fun setupView() {
    val numberOfPeople = findViewById<EditText>(R.id.activity_main_people_count_value)
    val totalBill = findViewById<EditText>(R.id.activity_main_total_bill_value)
    val tipPercentage = findViewById<EditText>(R.id.activity_main_tip_percent_value)
    resultTextView = findViewById(R.id.activity_main_result)
    val calculateButton = findViewById<Button>(R.id.activity_main_calculate_button)
    calculateButton.setOnClickListener {
      when {
        numberOfPeople.text?.toString()?.isBlank() == true -> numberOfPeople.error = "Enter number of people"
        totalBill.text?.toString()?.isBlank() == true -> totalBill.error = "Enter the bill amount"
        tipPercentage.text?.toString()?.isBlank() == true -> tipPercentage.error = "Enter tip percentage"
        else -> viewModel.computeTip(
            numberOfPeople = numberOfPeople.text.toString().toInt(),
            tipPercentage = tipPercentage.text.toString().toDouble(),
            totalBill = totalBill.text.toString().toDouble()
        )
      }
    }
  }

  override fun onResume() {
    super.onResume()
    viewModel.result.observe(this, Observer { result ->
      result?.let {
        resultTextView.text = it
      }
    })
  }
}
