/*
 * Copyright (c) 2018 FishWaffle.
 */
using UnityEngine;
using System;

namespace AndroidPlugin
{
    public class DialogFragment : MonoBehaviour
    {
        /// <summary>
        /// ダイアログを表示する.
        /// </summary>
        /// <param name="title">タイトル</param>
        /// <param name="message">メッセージ/param>
        /// <param name="positiveMessage">ボタンに表示するメッセージ</param>
        /// <param name="negativeMessage">ボタンに表示するメッセージ</param>
        /// <param name="cancelable">画面外タップで閉じるか否か</param>
        /// <param name="gameObjectName">Callbackを指定する場合のみ必須</param>
        /// <param name="positiveCallbackName">ボタン押下のCallbackメソッドの名前</param>
        /// <param name="negativeCallbackName">ボタン押下のCallbackメソッドの名前</param>
        public static void showDialogFragment(string title = null, string message = null,
            string positiveMessage = null, string negativeMessage = null, bool cancelable = true,
            string gameObjectName = null, string positiveCallbackName = null, string negativeCallbackName = null)
        {
            using (var javaObj = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyDialogFragmentKt"))
            {
                javaObj.CallStatic("showDialogFragment", title, message, positiveMessage, negativeMessage, cancelable,
                    gameObjectName, positiveCallbackName, negativeCallbackName);
            }
        }
    }
}