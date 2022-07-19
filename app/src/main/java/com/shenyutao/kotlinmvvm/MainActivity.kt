package com.shenyutao.kotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.shenyutao.kotlinmvvm.bean.User
import com.shenyutao.kotlinmvvm.databinding.ActivityMainBinding
import com.shenyutao.kotlinmvvm.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel:UserViewModel
    private var mActivityMainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        userViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(UserViewModel::class.java)

        val user = User("Szy", "22")
        userViewModel.mUserLiveData.value = user
        mActivityMainBinding?.userViewModel = userViewModel
        mActivityMainBinding?.lifecycleOwner = this
    }


}