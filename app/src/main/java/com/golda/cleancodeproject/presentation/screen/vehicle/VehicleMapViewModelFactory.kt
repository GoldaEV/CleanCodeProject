package com.golda.cleancodeproject.presentation.screen.vehicle

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.golda.cleancodeproject.app.UseCaseProvider

class VehicleMapViewModelFactory : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VehicleMapsViewModel(UseCaseProvider.provideGetVehicleUseCase()) as T
    }
}