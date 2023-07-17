package com.example.movies.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(val database: TopicsData) : ViewModel() {
    val topics = database.loadTopics()

    private val _navigateToSelectedTopic = MutableLiveData<String>()
    val navigateToSelectedTopic: LiveData<String> get() = _navigateToSelectedTopic

    fun displayMoviesFromTopic(apiText: String) {
        _navigateToSelectedTopic.value = apiText
    }
}