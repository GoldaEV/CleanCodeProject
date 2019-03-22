package com.golda.cleancodeproject.presentation.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {


    private val text: String by lazy(LazyThreadSafetyMode.NONE) { // Ленивое создание переменной. Инициализируется при первом обращении
        "Hello"
    }

    protected val lazyDisposable: Lazy<CompositeDisposable> = lazy(LazyThreadSafetyMode.NONE){
        CompositeDisposable()
    }

    protected val disposable : CompositeDisposable by lazyDisposable


    override fun onCleared() {
        super.onCleared()
        if (lazyDisposable.isInitialized()) {
            disposable.dispose()
        }
    }


}