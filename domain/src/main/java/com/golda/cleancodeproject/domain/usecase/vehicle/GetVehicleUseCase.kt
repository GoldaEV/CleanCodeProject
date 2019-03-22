package com.golda.cleancodeproject.domain.usecase.vehicle

import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface GetVehicleUseCase {

    fun get() : Single<List<Vehicle>>
}