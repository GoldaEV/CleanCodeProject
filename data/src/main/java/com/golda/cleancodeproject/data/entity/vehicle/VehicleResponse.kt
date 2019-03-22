package com.golda.cleancodeproject.data.entity.vehicle

internal class VehicleResponse(
    val id: Int,
    val coordinate: CoordinateResponse,
    val fleetType: String,
    val heading: Double
)