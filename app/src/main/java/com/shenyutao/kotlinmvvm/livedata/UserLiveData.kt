package com.shenyutao.kotlinmvvm.livedata

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import com.shenyutao.kotlinmvvm.bean.User

class UserLiveData(name: String, age: String) : LiveData<User>() {
    var mName = name
    set(value){
        field = value;
    }



    var mAge = age
}