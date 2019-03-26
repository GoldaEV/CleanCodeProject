package com.golda.cleancodeproject.presentation.screen.vehicle.list

import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle

sealed class VehicleState {

    object Progress : VehicleState()
    class Done(val vehicleList: List<Vehicle>) : VehicleState()
    class Error(val throwable: Throwable) : VehicleState()
}