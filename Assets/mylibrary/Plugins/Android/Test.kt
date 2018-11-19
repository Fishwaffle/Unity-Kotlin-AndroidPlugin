/*
 * Copyright (c) 2018 FishWaffle.
 */

package com.example.fishwaffle.mylibrary

import android.util.Log

fun PackageLevelFunction() {
    Log.d("TEST", "PackageLevelFunction")
}

object MyObject {
     fun MyObjectFunction() {
        Log.d("TEST", "MyObjectFunction")
    }

}

class MyClass {

    companion object {
        fun MyClassCompanionObjectFunction() {
            Log.d("TEST", "MyClassCompanionObjectFunction")
        }
    }

    fun MyClassFunction() {
        Log.d("TEST", "MyClassFunction")
    }

}
