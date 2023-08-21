package com.example.multiapirxmvvmapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multiapirxmvvmapp.data.network.model.ResponseAllUsers
import com.example.multiapirxmvvmapp.data.network.model.ResponseDetailsList
import com.example.multiapirxmvvmapp.data.repository.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    val responseAllUsers = MutableLiveData<ResponseAllUsers>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    val responseDetailsList = MutableLiveData<ResponseDetailsList>()
    val errorMessageDetails = MutableLiveData<String>()

    fun getAllUsersList() {
        val responseAllUsers = mainRepository.getAllUsersList()
        val responseDetailsList = mainRepository.getDetailsList()

        responseAllUsers.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getAllUsersListObserver())
    }

    private fun getAllUsersListObserver(): Observer<ResponseAllUsers> {
        return object : Observer<ResponseAllUsers>{
            override fun onSubscribe(d: Disposable) {
                disposable = d
                // Start showing progress dialog
            }

            override fun onError(e: Throwable) {
                errorMessage.postValue(e.message)
            }

            override fun onComplete() {
                // Stop showing progress dialog
            }

            override fun onNext(t: ResponseAllUsers) {
                responseAllUsers.postValue(t)
            }
        }
    }
}