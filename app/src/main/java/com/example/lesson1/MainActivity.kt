package com.example.lesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lesson1.SecondActivity.Companion.KEY_FOR_TEXT
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        setData()
    }

    private fun initClickers() {
        binding.btnSubmit.setOnClickListener {
            if (binding.editText.text.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(KEY_FOR_RESULT,binding.editText.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this,getString(R.string.not_empty),Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setData() {
        val result = intent.getStringExtra(KEY_FOR_TEXT)
        binding.tvResult.text = result
    }

    companion object{
        const val KEY_FOR_RESULT = "keyResult"
    }

}