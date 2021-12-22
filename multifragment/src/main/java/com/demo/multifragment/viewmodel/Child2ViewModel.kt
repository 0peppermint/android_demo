package com.demo.multifragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Child2ViewModel: ViewModel() {

    private val data: MutableLiveData<Int> = MutableLiveData(2)
}