package by.itacademy.cleancodeproject.app

import by.itacademy.cleancodeproject.BuildConfig
import by.itacademy.cleancodeproject.data.repository.vehicle.VehicleRepositoryRemote
import by.itacademy.cleancodeproject.domain.usecase.vehicle.GetVehicleUseCase
import by.itacademy.cleancodeproject.domain.usecase.vehicle.GetVehicleUseCaseDefault
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UseCaseProvider {

    fun provideGetVehicleUseCase() : GetVehicleUseCase {
        return GetVehicleUseCaseDefault(
            workScheduler = getWorkScheduler(),
            postScheduler = getUiScheduler(),
            vehicleRepository = VehicleRepositoryRemote(BuildConfig.API_ENDPOINT)
        )
    }

    private fun getWorkScheduler() = Schedulers.io()

    private fun getUiScheduler() = AndroidSchedulers.mainThread()
}