package com.golda.cleancodeproject.domain.usecase.vehicle

import com.golda.cleancodeproject.domain.entity.vehicle.CoordinateParam
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.domain.repository.vehicle.VehicleRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetVehicleUseCaseDefault(
    private val workScheduler: Scheduler,
    private val postScheduler: Scheduler,
    private val vehicleRepository: VehicleRepository
) : GetVehicleUseCase {

    override fun get(): Single<List<Vehicle>> {

        val coordinateParam = CoordinateParam(
            2.5, 2.6, 2.9, 4.3
        )

        return vehicleRepository
            .fetch(coordinateParam)
            .subscribeOn(workScheduler)
            .observeOn(postScheduler)
    }
}