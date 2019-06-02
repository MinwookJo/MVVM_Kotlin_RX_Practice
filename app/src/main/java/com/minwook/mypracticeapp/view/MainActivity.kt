package com.minwook.mypracticeapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.minwook.mypracticeapp.R
import com.minwook.mypracticeapp.base.BaseKotlinActivity
import com.minwook.mypracticeapp.databinding.ActivityMainBinding
import com.minwook.mypracticeapp.model.DataModel
import com.minwook.mypracticeapp.model.DataModelImpl
import com.minwook.mypracticeapp.viewModel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity: BaseKotlinActivity<ActivityMainBinding>(){
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    // private val viewModelFactory: ViewModelFactory by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainViewModel()
/*
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
*/

        viewModel.clickButton.observe(this, Observer {
            t -> Toast.makeText(this@MainActivity, t, Toast.LENGTH_LONG).show()
        })
        viewDataBinding.viewModel = viewModel;
        viewDataBinding.setLifecycleOwner(this)
    }
}