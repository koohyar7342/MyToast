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
            MyToast.show(
                this, "copied",

                MyToast.DialogType.COPY,
                2500, MyToast.DialogPosition.BOTTOM,
                lifecycle,

            )
            //MyToast.show(this, "copied")
        }
        binding.defaultBt.setOnClickListener {

            MyToast.show(
                this, "DEFAULT",
                MyToast.DialogType.DEFAULT,
                2500, MyToast.DialogPosition.BOTTOM
            )
        }
        binding.info.setOnClickListener {

            MyToast.show(
                this, "INFO",
                MyToast.DialogType.INFO,
                2500, MyToast.DialogPosition.TOP
            )
        }
        binding.done.setOnClickListener {

            MyToast.show(
                this,
                "موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",
                MyToast.DialogType.SUCCESS,
                2500,
                MyToast.DialogPosition.BOTTOM
            )
        }
        binding.error.setOnClickListener {

            MyToast.show(
                this, "ERROR",
                MyToast.DialogType.ERROR,
                2500, MyToast.DialogPosition.CENTER
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