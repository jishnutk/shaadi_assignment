package com.e.shaadi.util

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.e.shaadi.R
import com.e.shaadi.models.Result

class BindingAdapter {

    companion object {
        @JvmStatic
        @androidx.databinding.BindingAdapter(value = ["setImgUrl"])
        fun setImage(imageView: ImageView, url: String?) {
            url?.let {
                Glide.with(imageView.context)
                    .load(url)
                    .into(imageView);
            }
        }

        @JvmStatic
        @androidx.databinding.BindingAdapter(value = ["setCircularImgUrl"])
        fun setCircularImage(imageView: ImageView, url: String?) {
            url?.let {
                Glide.with(imageView.context)
                    .load(url)
                    .circleCrop()
                    .into(imageView);
            }
        }

        @JvmStatic
        @androidx.databinding.BindingAdapter(value = ["details"])
        fun setDetails(textView: TextView, result: Result?) {
            result?.let {
                val details = StringBuilder().append(it.dob.age)
                    .append(", ")
                    .append(it.location.city)
                    .append("\n")
                    .append(it.location.state)
                    .append(", ")
                    .append(it.location.country)
                textView.text = details.toString()
            }
        }


        @JvmStatic
        @androidx.databinding.BindingAdapter(value = ["status"])
        fun setStatus(textView: TextView, result: Result?) {
            result?.let {
                var text = ""
                it.status?.let { status ->
                    if (status) {
                        text = "Accepted"
                        textView.setTextColor(
                            ContextCompat.getColor(
                                textView.context,
                                R.color.teal_700
                            )
                        )

                    } else {
                        text = "Declined"
                        textView.setTextColor(
                            ContextCompat.getColor(
                                textView.context,
                                R.color.red))
                    }
                }
                if (text.isEmpty()) {
                    textView.visibility = View.GONE
                } else {
                    textView.visibility = View.VISIBLE
                    textView.text = text
                }
            }
        }
    }
}