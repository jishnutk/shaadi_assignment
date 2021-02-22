package com.e.shaadi.ui

import com.e.shaadi.models.Result

interface onClickHandler {
    fun onClickViewItem(data: Result, position : Int)
}