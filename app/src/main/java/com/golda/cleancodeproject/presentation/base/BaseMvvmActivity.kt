package com.golda.cleancodeproject.presentation.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseMvvmActivity<VM: BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel : VM

    @LayoutRes
    protected abstract fun provideLayoutId() : Int

    protected abstract fun provideVievModel() : VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        viewModel = provideVievModel()
        setContentView(provideLayoutId())
    }

}