using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Test : MonoBehaviour
{
    public void PackageLevelFunction()
    {
        using (var javaClass = new AndroidJavaClass("com.example.fishwaffle.mylibrary.TestKt"))
        {
            javaClass.CallStatic("PackageLevelFunction");
        }
    }

    public void MyObjectFunctionA()
    {
        using (var javaClass = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyObject"))
        {
            using (var instance = javaClass.GetStatic<AndroidJavaObject>("INSTANCE"))
            {
                instance.Call("MyObjectFunction");
            }
        }

    }
    public void MyObjectFunctionB()
    {
        using (var javaObj = new AndroidJavaObject("com.example.fishwaffle.mylibrary.MyObject"))
        {
            javaObj.Call("MyObjectFunction");
        }

    }

    public void MyClassCompanionObjectFunction()
    {
        using (var javaClass = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyClass"))
        {
            using (var companion = javaClass.GetStatic<AndroidJavaObject>("Companion"))
            {
                companion.Call("MyClassCompanionObjectFunction");
            }
        }
    }
    public void MyClassFunction()
    {
        using (var javaObj = new AndroidJavaObject("com.example.fishwaffle.mylibrary.MyClass"))
        {
            javaObj.Call("MyClassFunction");
        }

    }

}
