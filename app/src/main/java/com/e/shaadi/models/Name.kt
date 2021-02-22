package com.e.shaadi.models

data class Name(
    val first: String,
    val last: String,
    val title: String
) {
    fun getName() :String {
        return "$first $last"
    }
}