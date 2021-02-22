package com.e.shaadi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.e.shaadi.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomeViewModel(private val application: Application, private val repository: Repository) :
    ViewModel() {

    private val viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getMatches() = liveData(Dispatchers.IO) {
        try {
            val matches = repository.fetchMatches()
            emit(Resource.success(data = matches.results))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}