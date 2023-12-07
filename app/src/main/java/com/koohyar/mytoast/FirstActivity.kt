package com.koohyar.mytoast

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.koohyar.mytoast.databinding.ActivityFirstBinding

class FirstActivity: AppCompatActivity() {

    lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goToMain.setOnClickListener {
            startActivity(Intent(this,MainActivity().javaClass))
        }
    }
}