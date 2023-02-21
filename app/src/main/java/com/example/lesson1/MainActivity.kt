package com.example.lesson1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson1.Key.KEY_FOR_RESULT
import com.example.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pickText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        setData()
        initLauncher()
    }

    private fun initLauncher() {
        pickText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.editText.setText(result.data?.getStringExtra(KEY_FOR_RESULT))
                }
            }
    }

    private fun initClickers() {
        binding.btnTransfer.setOnClickListener {
            if (binding.editText.text.isNotEmpty()) {
                transferData()
            } else {
                makeText(this, getString(R.string.not_empty))
            }
        }
    }

    private fun transferData() {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra(KEY_FOR_RESULT, binding.editText.text.toString())
        pickText.launch(intent)
    }

    private fun setData() {
        binding.editText.setText(intent.getStringExtra(KEY_FOR_RESULT))
    }
}