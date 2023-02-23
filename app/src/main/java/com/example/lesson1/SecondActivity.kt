package com.example.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson1.Key.KEY_FOR_RESULT
import com.example.lesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        setData()
    }

    private fun setData() {
        binding.edText.setText(intent.getStringExtra(KEY_FOR_RESULT))
    }


    private fun initClickers() {
        binding.btnReturn.setOnClickListener {
            setResult(
                RESULT_OK,Intent().putExtra(
                    KEY_FOR_RESULT,binding.edText.text.toString()
                )
            )
            finish()
        }
    }

}