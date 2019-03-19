package by.itacademy.cleancodeproject.domain.repository.vehicle

import by.itacademy.cleancodeproject.domain.entity.vehicle.CoordinateParam
import by.itacademy.cleancodeproject.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface VehicleRepository {

    fun fetch(param: CoordinateParam) : Single<List<Vehicle>>
}