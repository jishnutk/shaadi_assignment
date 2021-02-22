package com.e.shaadi.ui

import com.e.shaadi.network.APINetwork

class Repository(private val network: APINetwork) {
    suspend fun fetchMatches() = network.fetchMatches(10)
}