package com.golda.cleancodeproject.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseMvvmFragment<VM: BaseViewModel> : Fragment() {

    protected lateinit var viewModel: VM

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun provideViewModel() : VM

    /**
     * Будет вызвана только после инифиализации viewModel
     */
    protected abstract fun initView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(provideLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = provideViewModel()
        initView()
    }
}