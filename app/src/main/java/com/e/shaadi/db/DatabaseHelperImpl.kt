package com.e.shaadi.db

import com.e.shaadi.models.Result

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getAllProfiles(): List<Result> =
        appDatabase.profileDao().getAll()

    override suspend fun insertAll(results: List<Result>) =
        appDatabase.profileDao().insertAll(results)

    override suspend fun updateProfile(profile: Result) =
        appDatabase.profileDao().updateUsers(profile)

}