package com.raywenderlich.android.tipcalculator

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by kalyandechiraju on 18/11/18.
 * Playo
 */
class MainActivityViewModel : ViewModel() {
  private val _result: MutableLiveData<String> = MutableLiveData()
  val result: LiveData<String>
    get() = _result

  fun computeTip(numberOfPeople: Int, tipPercentage: Double, totalBill: Double) {
    // TODO implement the tip computation logic
  }

}