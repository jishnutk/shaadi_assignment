package com.e.shaadi.ui

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.shaadi.db.DatabaseBuilder
import com.e.shaadi.db.DatabaseHelperImpl
import com.e.shaadi.models.Result
import com.e.shaadi.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application, private val repository: Repository) :
    ViewModel() {

    var profiles: MutableLiveData<Resource<ArrayList<Result>>> = MutableLiveData()
    val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(application))

    init {
//        fetchMatchesFromDb()
    }

    fun fetchMatchesFromDb() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val matches = dbHelper.getAllProfiles()
                    profiles.postValue( Resource.success(data = ArrayList(matches)))
                }
            } catch (e: Exception) {
                profiles.value =
                    Resource.error(data = null, message = e.message ?: "Error Occurred!")
            }
        }
    }

    private fun saveAll(profiles: ArrayList<Result>) {
        viewModelScope.launch {
            try {
                dbHelper.insertAll(profiles)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateProfile(profile: Result) {
        viewModelScope.launch {
            try {
                dbHelper.updateProfile(profile)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private val viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getNewMatches() {
        viewModelScope.launch {
            try {
                val matches = repository.fetchMatches()
                saveAll(matches.results)
                profiles.postValue(Resource.success(data = matches.results))
            } catch (e: Exception) {
                profiles.value =
                    Resource.error(data = null, message = e.message ?: "Error Occurred!")
            }
        }
    }

}