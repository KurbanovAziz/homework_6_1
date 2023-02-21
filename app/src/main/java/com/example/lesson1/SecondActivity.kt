package com.example.lesson1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson1.Key.KEY_FOR_RESULT
import com.example.lesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var result: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLauncher()
        initClickers()
        setData()
    }

    private fun setData() {
        binding.edText.setText(intent.getStringExtra(KEY_FOR_RESULT))
    }

    private fun initLauncher() {
        result =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.edText.setText(result.data?.getStringExtra(KEY_FOR_RESULT))
                }
            }
    }

    private fun initClickers() {
        binding.btnReturn.setOnClickListener {
            if (binding.edText.text.isNotEmpty()) {
                transferData()
            } else {
                makeText(this, getString(R.string.not_empty))
            }
        }
    }

    private fun transferData() {
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        intent.putExtra(KEY_FOR_RESULT, binding.edText.text.toString())
        result.launch(intent)
    }
}