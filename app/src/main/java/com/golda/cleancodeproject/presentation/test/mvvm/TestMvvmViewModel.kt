package com.golda.cleancodeproject.presentation.test.mvvm

interface TestMvvmViewModel {

    fun setHelloTextListener(listener: HelloTextListener);
    fun reloadData()
    fun helloClick()
}