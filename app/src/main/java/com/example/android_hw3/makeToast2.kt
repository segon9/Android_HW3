package com.example.android_hw3

import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

fun Activity.makeToast2(msg : String) {
//    바로 아래에 있는 코드는 LayoutInflater를 가져오는 가장 기본적인 방법이다.
    val inflater : LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.custom_toast, this.findViewById(R.id.cl_toast_container))
    Toast(this).apply {
        layout.findViewById<TextView>(R.id.tv_toast_msg).text = msg
        view = layout
        duration = Toast.LENGTH_SHORT
        setGravity(Gravity.BOTTOM, 0, 100)
        show()
    }

}