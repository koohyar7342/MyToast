package com.koohyar.mytoast

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat

object DialoguesUtils {
    enum class DialogPosition {
        TOP, CENTER, BOTTOM
    }

    enum class DialogType {
        DEFAULT, INFO, ERROR, COPY,SUCCESS
    }

    fun hideNavigationBarAndOpeningDialog(dialog: AppCompatDialog) {
        val ui_flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        dialog.window!!.decorView.systemUiVisibility = ui_flags;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            dialog.window!!.decorView.windowInsetsController?.hide(WindowInsets.Type.navigationBars())
        }
        dialog.show()
        dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    var currentDialog: Dialog? = null
    fun hideNavigationBarAndOpeningDialog(dialog: Dialog) {
        val ui_flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        dialog.window!!.decorView.systemUiVisibility = ui_flags;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            dialog.window!!.decorView.windowInsetsController?.hide(WindowInsets.Type.navigationBars())
        }
        dialog.show()
        dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }


    fun showAlertDialogWithJustMessage(
        context: Context,
        message: String,
        type: DialogType = DialogType.DEFAULT,
        delayMillis: Long = 2500,
        position: DialogPosition = DialogPosition.BOTTOM

    ) {


        val dialogView =
            LayoutInflater.from(context)
                .inflate(R.layout.dialog_snack_message, FrameLayout(context))
        val textView = dialogView.findViewById<TextView>(R.id.alert_dialog_view_textView)
        textView.text = message
        val icon = dialogView.findViewById<ImageView>(R.id.alert_dialog_icon)
        val mainLayout = dialogView.findViewById<CardView>(R.id.alert_dialog_main_layout)




        val dialog = Dialog(context, R.style.CustomMaterialDialog)

        dialog.setContentView(dialogView)



        when (type) {
            DialogType.DEFAULT -> {
                icon.visibility = View.GONE
                mainLayout.setCardBackgroundColor(getColor(context, android.R.color.darker_gray))
                dialog.window?.attributes!!.windowAnimations = R.style.animation_scale_in_fade_out

            }

            DialogType.INFO -> {
                icon.setImageResource(R.drawable.outline_info_24)
                dialog.window?.attributes!!.windowAnimations = R.style.animation_scale_in_fade_out
                mainLayout.setCardBackgroundColor(getColor(context, R.color.pass_blue_dark))
                // if (dialogPosition == DialogPosition.BOTTOM)
                // dialogPosition = DialogPosition.CENTER


            }

            DialogType.ERROR -> {
                icon.setImageResource(R.drawable.round_error_24)
                mainLayout.setCardBackgroundColor(getColor(context, R.color.pass_pink_dark))
                dialog.window?.attributes!!.windowAnimations = R.style.animation_slide_error


            }

            DialogType.COPY -> {
                icon.setImageResource(R.drawable.round_content_copy_24)
                mainLayout.setCardBackgroundColor(getColor(context, R.color.mt_copy_background_color))
                dialog.window?.attributes!!.windowAnimations = R.style.animation_slide_from_bottom


            }

            DialogType.SUCCESS -> {
                icon.setImageResource(R.drawable.round_done_24)
                mainLayout.setCardBackgroundColor(getColor(context, R.color.pass_green_dark))
                dialog.window?.attributes!!.windowAnimations = R.style.animation_scale_in_fade_out


            }
        }



        dialog.setCanceledOnTouchOutside(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
        );
        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );
        dialog.window!!.setFlags(
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
        )
        val layoutParams: WindowManager.LayoutParams = dialog.window!!.attributes
        val physicalHeightPx = context.physicalScreenRectPx.height()
        val physicalWidthPx = context.physicalScreenRectPx.width()
        layoutParams.x = 0


        when (position) {
            DialogPosition.BOTTOM -> {

                layoutParams.y = physicalHeightPx / 3
            }

            DialogPosition.CENTER -> {
                layoutParams.y = 0
            }

            DialogPosition.TOP -> {
                layoutParams.y = physicalHeightPx / (-3)
            }
        }
        dialog.window!!.setDimAmount(0.1f)


        currentDialog = dialog
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)

        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        dialog.show()

        //hideNavigationBarAndOpeningDialog1(context,dialog)
        dialog.window!!.setLayout(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            //physicalWidthPx*2/3,
            //400,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )



        Handler(Looper.getMainLooper()).postDelayed({
            //Log.d("showAlertDialog", "dismiss")
            dialog.dismiss()

        }, delayMillis)

    }
    private fun getColor(context: Context, id: Int): Int {
          return  context.resources.getColor(id, null)

    }
    private fun getDrawable(context: Context, id: Int):Drawable{
        return  ResourcesCompat.getDrawable(context.resources,id,context.theme)!!
    }

}

