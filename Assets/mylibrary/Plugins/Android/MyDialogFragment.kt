/*
 * Copyright (c) 2018 FishWaffle.
 */

package com.example.fishwaffle.mylibrary

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import com.unity3d.player.UnityPlayer

object MyDialogFragment {
    fun showDialogFragment(title: String = "", message: String = "", positiveMessage: String = "", negativeMessage: String = "", cancelable: Boolean = false, gameObjectName: String = "") {
        val dialog = MyAlertDialogFragment()
        val args = Bundle()
        args.putString("title", title)
        args.putString("message", message)
        args.putString("positiveMessage", positiveMessage)
        args.putString("negativeMessage", negativeMessage)
        args.putBoolean("cancelable", cancelable)
        args.putString("gameObjectName", gameObjectName)
        dialog.arguments = args

        UnityPlayer.currentActivity.runOnUiThread {
            dialog.show(UnityPlayer.currentActivity.fragmentManager, MyAlertDialogFragment::class.java.simpleName)
        }

    }

    class MyAlertDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val title = arguments.getString("title")
            val message = arguments.getString("message")
            val positiveMessage = arguments.getString("positiveMessage")
            val negativeMessage = arguments.getString("negativeMessage")
            isCancelable = arguments.getBoolean("cancelable")
            val gameObjectName = arguments.getString("gameObjectName")

            return AlertDialog.Builder(activity).apply {
                if (title.isNotEmpty()) {
                    setTitle(title)
                }
                if (message.isNotEmpty()) {
                    setMessage(message)
                }
                if (positiveMessage.isNotEmpty()) {
                    setPositiveButton(positiveMessage) { _, _ ->
                        if (gameObjectName.isNotEmpty()) {
                            UnityPlayer.UnitySendMessage(gameObjectName, "onDialogPositiveButton", "")
                        }
                    }
                }
                if (negativeMessage.isNotEmpty()) {
                    setNegativeButton(negativeMessage) { _, _ ->
                        if (gameObjectName.isNotEmpty()) {
                            UnityPlayer.UnitySendMessage(gameObjectName, "onDialogNegativeButton", "")
                        }
                    }
                }
            }.create()
        }

    }
}