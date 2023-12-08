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
                context = this,
                message = "the toast message",
                type = MyToast.DialogType.ERROR, // DEFAULT,INFO,SUCCESS,COPY
                delayMillis = 2500, // Toast duration in Millisecond
                position = MyToast.DialogPosition.CENTER, // CENTER, BOTTOM, TOP
                lifecycle= lifecycle // for dismissing toast when lifecycleOwner finished
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