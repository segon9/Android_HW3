package com.example.android_hw3

import android.content.Context
import android.widget.Toast

fun Context.makeToast(msg : String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}