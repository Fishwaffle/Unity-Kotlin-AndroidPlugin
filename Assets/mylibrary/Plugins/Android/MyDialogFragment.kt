/*
 * Copyright (c) 2018 FishWaffle.
 */

package com.example.fishwaffle.mylibrary

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import com.unity3d.player.UnityPlayer

fun showDialogFragment(title: String = "", message: String = "", positiveMessage: String = "", negativeMessage: String = "", cancelable: Boolean = false,
                       gameObjectName: String = "", positiveCallbackName: String = "", negativeCallbackName: String = "") {
    val dialog = MyDialogFragment()
    dialog.arguments = Bundle().apply {
        putString("title", title)
        putString("message", message)
        putString("positiveMessage", positiveMessage)
        putString("negativeMessage", negativeMessage)
        putString("gameObjectName", gameObjectName)
        putString("positiveCallbackName", positiveCallbackName)
        putString("negativeCallbackName", negativeCallbackName)
        putBoolean("cancelable", cancelable)
    }

    UnityPlayer.currentActivity.runOnUiThread {
        dialog.show(UnityPlayer.currentActivity.fragmentManager, MyDialogFragment::class.java.simpleName)
    }

}

 class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments.getString("title")
        val message = arguments.getString("message")
        val positiveMessage = arguments.getString("positiveMessage")
        val negativeMessage = arguments.getString("negativeMessage")
        val gameObjectName = arguments.getString("gameObjectName")
        val positiveCallbackName = arguments.getString("positiveCallbackName")
        val negativeCallbackName = arguments.getString("negativeCallbackName")
        isCancelable = arguments.getBoolean("cancelable")

        return AlertDialog.Builder(activity).apply {
            if (title.isNotEmpty()) {
                setTitle(title)
            }
            if (message.isNotEmpty()) {
                setMessage(message)
            }
            if (positiveMessage.isNotEmpty()) {
                setPositiveButton(positiveMessage) { _, _ ->
                    if (gameObjectName.isNotEmpty() && positiveCallbackName.isNotEmpty()) {
                        UnityPlayer.UnitySendMessage(gameObjectName, positiveCallbackName, "")
                    }
                }
            }
            if (negativeMessage.isNotEmpty()) {
                setNegativeButton(negativeMessage) { _, _ ->
                    if (gameObjectName.isNotEmpty() && positiveCallbackName.isNotEmpty()) {
                        UnityPlayer.UnitySendMessage(gameObjectName, negativeCallbackName, "")
                    }
                }
            }
        }.create()
    }

}