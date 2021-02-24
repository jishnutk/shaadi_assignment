package com.e.shaadi.db

import androidx.room.*
import com.e.shaadi.models.Result

@Dao
interface ProfileDao {
    @Insert
    fun insertAll(profiles: List<Result>)

    @Delete
    fun delete(profile: Result)

    @Query("SELECT * FROM profiles")
    fun getAll(): List<Result>

    @Update
    fun updateUsers(vararg profile: Result)
}