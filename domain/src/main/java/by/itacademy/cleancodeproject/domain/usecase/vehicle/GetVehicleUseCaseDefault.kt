package by.itacademy.cleancodeproject.domain.usecase.vehicle

import by.itacademy.cleancodeproject.domain.entity.vehicle.CoordinateParam
import by.itacademy.cleancodeproject.domain.entity.vehicle.Vehicle
import by.itacademy.cleancodeproject.domain.repository.vehicle.VehicleRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetVehicleUseCaseDefault(
    private val workSchedulers: Scheduler,
    private val postSchedulers: Scheduler,
    private val vehicleRepository: VehicleRepository
) : GetVehicleUseCase {

    override fun get(): Single<List<Vehicle>> {

        val coordinateParam = CoordinateParam(
            2.5, 2.6, 2.9, 4.3
        )

        return vehicleRepository
            .fetch(coordinateParam)
            .subscribeOn(workSchedulers)
            .observeOn(postSchedulers)
    }
}