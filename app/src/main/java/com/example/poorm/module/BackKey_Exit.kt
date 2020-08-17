package com.example.poorm.module

import android.content.Context
import android.widget.Toast

private var backKeyPressedTime: Long = 0
private var toast: Toast? = null

fun backExit(context: Context, func: () -> Unit) {
    if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
        backKeyPressedTime = System.currentTimeMillis()
        toast = Toast.makeText(context, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG)
        toast!!.show()
    } else {
        toast!!.cancel()
        toast = Toast.makeText(context, "이용해 주셔서 감사합니다.", Toast.LENGTH_LONG)
        toast!!.show()
        func()
    }
}