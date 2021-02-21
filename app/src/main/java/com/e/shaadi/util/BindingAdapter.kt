package com.e.shaadi.util

import android.widget.ImageView
import com.bumptech.glide.Glide

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
    }
}