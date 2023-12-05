package com.koohyar.mytoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.koohyar.mytoast.R
import com.koohyar.mytoast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.copy.setOnClickListener {

            DialoguesUtils.showAlertDialogWithJustMessage(
                this,"copied",
                DialoguesUtils.DialogType.COPY,
                2500,DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.defaultBt.setOnClickListener {

            DialoguesUtils.showAlertDialogWithJustMessage(
                this,"DEFAULT",
                DialoguesUtils.DialogType.DEFAULT,
                2500,DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.info.setOnClickListener {

            DialoguesUtils.showAlertDialogWithJustMessage(
                this,"INFO",
                DialoguesUtils.DialogType.INFO,
                2500,DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.done.setOnClickListener {

            DialoguesUtils.showAlertDialogWithJustMessage(
                this,"موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",
                DialoguesUtils.DialogType.SUCCESS,
                2500,DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.error.setOnClickListener {

            DialoguesUtils.showAlertDialogWithJustMessage(
                this,"ERROR",
                DialoguesUtils.DialogType.ERROR,
                2500,DialoguesUtils.DialogPosition.BOTTOM
            )
        }
        binding.toast.setOnClickListener {
            Toast.makeText(this,"موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز موفقیت آمیز",Toast.LENGTH_SHORT).show()
        }
    }
}