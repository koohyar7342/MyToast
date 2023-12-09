package com.koohyar.mytoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

                MyToast.ToastType.COPY,
                2500, MyToast.ToastPosition.BOTTOM,
                lifecycle,

            )
            //MyToast.show(this, "copied")
        }
        binding.defaultBt.setOnClickListener {

            MyToast.show(
                this, "DEFAULT",
                MyToast.ToastType.DEFAULT,
                2500, MyToast.ToastPosition.BOTTOM
            )
        }
        binding.info.setOnClickListener {

            MyToast.show(
                this, "INFO",
                MyToast.ToastType.INFO,
                2500, MyToast.ToastPosition.TOP
            )
        }
        binding.done.setOnClickListener {

            MyToast.show(
                this,
                "موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",
                MyToast.ToastType.SUCCESS,
                2500,
                MyToast.ToastPosition.BOTTOM
            )
        }
        binding.error.setOnClickListener {

            MyToast.show(
                context = this,
                message = "the toast message",
                type = MyToast.ToastType.ERROR, // DEFAULT,INFO,SUCCESS,COPY
                delayMillis = 2500, // Toast duration in Millisecond
                position = MyToast.ToastPosition.CENTER, // CENTER, BOTTOM, TOP
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