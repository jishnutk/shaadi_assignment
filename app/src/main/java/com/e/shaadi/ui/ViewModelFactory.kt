package com.e.shaadi.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(app: Application, repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    private val repo: Repository = repository
    private val application: Application = app
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == HomeViewModel::class.java) {
            HomeViewModel(application, repo) as T
        } else {
            super.create(modelClass)
        }
    }

}