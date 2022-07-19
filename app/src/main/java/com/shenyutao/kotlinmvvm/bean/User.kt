package com.shenyutao.kotlinmvvm.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR


class User(name: String, age: String) : BaseObservable() {
    var mName = name
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.mName)
        }
    var mAge = age
}