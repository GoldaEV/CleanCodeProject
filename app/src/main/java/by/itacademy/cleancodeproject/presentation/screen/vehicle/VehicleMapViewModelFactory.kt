package by.itacademy.cleancodeproject.presentation.screen.vehicle

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import by.itacademy.cleancodeproject.app.UseCaseProvider

class VehicleMapViewModelFactory : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VehicleMapsViewModel(UseCaseProvider.provideGetVehicleUseCase()) as T
    }
}