package com.e.shaadi.db

import androidx.room.TypeConverter
import com.e.shaadi.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {

    @TypeConverter
    fun toResult(json: String): Result {
        val type = object : TypeToken<Result>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toResultJson(result: Result): String {
        val type = object : TypeToken<Result>() {}.type
        return Gson().toJson(result, type)
    }

    @TypeConverter
    fun fromString(value: String?): ArrayList<Result?>? {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Result?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun toDob(json: String): Dob {
        val type = object : TypeToken<Dob>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toDobJson(dob: Dob): String {
        val type = object : TypeToken<Dob>() {}.type
        return Gson().toJson(dob, type)
    }

    @TypeConverter
    fun toId(json: String): Id {
        val type = object : TypeToken<Id>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toDobJson(id: Id): String {
        val type = object : TypeToken<Id>() {}.type
        return Gson().toJson(id, type)
    }

    @TypeConverter
    fun toLocation(json: String): Location {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toLocationJson(location: Location): String {
        val type = object : TypeToken<Location>() {}.type
        return Gson().toJson(location, type)
    }

    @TypeConverter
    fun toLogin(json: String): Login {
        val type = object : TypeToken<Login>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toLoginJson(login: Login): String {
        val type = object : TypeToken<Login>() {}.type
        return Gson().toJson(login, type)
    }

    @TypeConverter
    fun toName(json: String): Name {
        val type = object : TypeToken<Name>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toNameJson(name: Name): String {
        val type = object : TypeToken<Name>() {}.type
        return Gson().toJson(name, type)
    }

    @TypeConverter
    fun toPicture(json: String): Picture {
        val type = object : TypeToken<Picture>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toPictureJson(picture: Picture): String {
        val type = object : TypeToken<Picture>() {}.type
        return Gson().toJson(picture, type)
    }

    @TypeConverter
    fun toRegistered(json: String): Registered {
        val type = object : TypeToken<Registered>() {}.type
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toRegisteredJson(registered: Registered): String {
        val type = object : TypeToken<Registered>() {}.type
        return Gson().toJson(registered, type)
    }

}