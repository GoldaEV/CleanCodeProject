package com.golda.cleancodeproject.app

import com.golda.cleancodeproject.BuildConfig
import com.golda.cleancodeproject.data.repository.vehicle.VehicleRepositoryRemote
import com.golda.cleancodeproject.domain.usecase.vehicle.GetVehicleUseCase
import com.golda.cleancodeproject.domain.usecase.vehicle.GetVehicleUseCaseDefault
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