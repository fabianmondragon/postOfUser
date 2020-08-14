package com.example.customview

import android.content.Context

class DataLoadStepperManager (var context: Context) {
    val REGISTER = "REGISTER"

    fun loadData ( type: String) : Array<out String> {
        when (type){
            REGISTER -> return loadDataRegister()
        }
        return arrayOf()
    }

    fun loadDataRegister (): Array<out String> {
        val array : Array<out String> =  context.resources.getStringArray(R.array.info_step_registration)
        return array
    }

    companion object{
        val REGISTER = "REGISTER"
    }


}