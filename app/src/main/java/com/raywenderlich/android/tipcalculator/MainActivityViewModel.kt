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
    val tipAmount = (totalBill * tipPercentage) / 100
    val totalAmountToPay = tipAmount + totalBill
    val billPerPerson = totalAmountToPay / numberOfPeople
    _result.postValue(String.format("$%.2f", billPerPerson))
  }

}