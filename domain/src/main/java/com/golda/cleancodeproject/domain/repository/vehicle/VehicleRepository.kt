package com.golda.cleancodeproject.domain.repository.vehicle

import com.golda.cleancodeproject.domain.entity.vehicle.CoordinateParam
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface VehicleRepository {

    fun fetch(param: CoordinateParam) : Single<List<Vehicle>>
}