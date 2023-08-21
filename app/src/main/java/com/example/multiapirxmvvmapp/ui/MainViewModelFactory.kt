package com.example.multiapirxmvvmapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.multiapirxmvvmapp.data.repository.MainRepository

class MainViewModelFactory constructor(private val mainRepository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java))
            MainViewModel(mainRepository) as T
        else
            throw IllegalArgumentException("View Model Not Found!")
    }
}