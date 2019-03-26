package com.golda.cleancodeproject.presentation.screen.vehicle.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.golda.cleancodeproject.app.UseCaseProvider

class VehicleListViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VehicleListViewModel(
            UseCaseProvider
                .provideGetVehicleUseCase()
        ) as T
    }
}