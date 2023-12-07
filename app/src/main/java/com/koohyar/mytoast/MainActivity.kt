package com.koohyar.mytoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.koohyar.mytoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finish.setOnClickListener {
            finish()
        }



        binding.copy.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({ finish() }, 500)
            DialoguesUtils.show(
                this, "copied",

                DialoguesUtils.DialogType.COPY,
                2500, DialoguesUtils.DialogPosition.BOTTOM,
                lifecycle,

            )
            DialoguesUtils.show(this, "copied")
        }
        binding.defaultBt.setOnClickListener {

            DialoguesUtils.show(
                this, "DEFAULT",
                DialoguesUtils.DialogType.DEFAULT,
                2500, DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.info.setOnClickListener {

            DialoguesUtils.show(
                this, "INFO",
                DialoguesUtils.DialogType.INFO,
                2500, DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.done.setOnClickListener {

            DialoguesUtils.show(
                this,
                "موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",
                DialoguesUtils.DialogType.SUCCESS,
                2500,
                DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.error.setOnClickListener {

            DialoguesUtils.show(
                this, "ERROR",
                DialoguesUtils.DialogType.ERROR,
                2500, DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.toast.setOnClickListener {
            Toast.makeText(
                this,
                "موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}