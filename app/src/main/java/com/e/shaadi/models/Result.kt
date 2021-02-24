package com.e.shaadi.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Profiles")
data class Result(
    val cell: String,
    val dob: Dob,
    @PrimaryKey val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered,
    var status : Boolean? = null
)