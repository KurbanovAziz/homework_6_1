package com.example.lesson1

import android.content.Context
import android.widget.Toast

fun Context.makeText(setText: String) {
    Toast.makeText(this, setText, Toast.LENGTH_SHORT).show()
}