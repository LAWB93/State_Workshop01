package com.example.workshop_user_interface

import android.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CustomViewModel:ViewModel () {
    var checkedBox by mutableStateOf(false)
        private set
    var backgroundColor by mutableStateOf(Color.RED)
        private set

    fun checkAllBoxes (){
        checkedBox =true}

    fun changeBackgroundColor () {
        backgroundColor=Color.RED
    }

}
