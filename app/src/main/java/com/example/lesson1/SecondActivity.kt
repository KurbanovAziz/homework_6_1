package com.example.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson1.MainActivity.Companion.KEY_FOR_RESULT
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
        val result = intent.getStringExtra(KEY_FOR_RESULT)
        binding.tvResult.text = result
    }

    private fun initClickers() {
        binding.btnReturn.setOnClickListener {
            if (binding.et.text.isNotEmpty()) {
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                intent.putExtra(KEY_FOR_TEXT,binding.et.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this,getString(R.string.not_empty), Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val KEY_FOR_TEXT = "resultEditText"
    }
}