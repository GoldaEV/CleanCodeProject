package by.itacademy.cleancodeproject.domain.usecase.vehicle

import by.itacademy.cleancodeproject.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface GetVehicleUseCase {

    fun get() : Single<List<Vehicle>>
}