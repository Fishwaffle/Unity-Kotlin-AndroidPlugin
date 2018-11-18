/*
 * Copyright (c) 2018 FishWaffle.
 */
using UnityEngine;
namespace AndroidPlugin
{
    public class Toast : MonoBehaviour
    {
        /// <summary>
        /// Toastを表示する.
        /// </summary>
        /// <param name="message">表示する文字列</param>
        /// <param name="duration">表示時間 0:SHORT 1:LONG</param>
        public static void show(string message, int duration)
        {
            using (var javaObj = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyToastKt"))
            {
                javaObj.CallStatic("showToast", message, duration);
            }
        }
    }
}