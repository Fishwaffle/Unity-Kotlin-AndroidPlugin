/*
 * Copyright (c) 2018 FishWaffle.
 */

package com.example.fishwaffle.mylibrary

import android.widget.Toast
import com.unity3d.player.UnityPlayer

/**
 * トースト表示
 * @param text     表示文字
 * @param duration 表示時間 0:SHORT 1:LONG
 */
fun showToast(text: String, duration: Int = 0) {
    UnityPlayer.currentActivity.runOnUiThread {
        Toast.makeText(UnityPlayer.currentActivity, text, duration).show()
    }
}