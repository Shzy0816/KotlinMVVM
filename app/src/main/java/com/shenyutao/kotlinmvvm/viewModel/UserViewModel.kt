package com.shenyutao.kotlinmvvm.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shenyutao.kotlinmvvm.bean.User
import com.shenyutao.kotlinmvvm.repository.UserRepository



class UserViewModel : ViewModel() {
    private val mUserRepository = UserRepository()
    var mUserLiveData: MutableLiveData<User> = MutableLiveData()

    suspend fun setUser(userId :String){
        mUserLiveData.value = mUserRepository.getUserById(userId)
    }

    fun changeUserPart(){
        mUserLiveData.value = User("SSS","23")
        Log.i("Test", "${mUserLiveData.value?.mName}")
    }

    fun changeUser(){
        mUserLiveData.value = User("SSS","23")
        Log.i("Test", "${mUserLiveData.value?.mName}")
    }
}