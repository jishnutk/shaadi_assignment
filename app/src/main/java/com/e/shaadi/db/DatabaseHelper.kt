package com.e.shaadi.db

import com.e.shaadi.models.Result

interface DatabaseHelper {
    suspend fun getAllProfiles(): List<Result>
    suspend fun insertAll(results: List<Result>)
    suspend fun updateProfile(profile: Result)
}