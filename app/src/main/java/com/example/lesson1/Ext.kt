package com.example.lesson1

import android.content.Context
import android.widget.Toast

fun makeText(context: Context, setText: String) {
    Toast.makeText(context, setText, Toast.LENGTH_SHORT).show()
}