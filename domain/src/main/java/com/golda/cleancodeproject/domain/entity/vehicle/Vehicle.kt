package com.golda.cleancodeproject.domain.entity.vehicle

import com.golda.cleancodeproject.domain.entity.DomainEntity

data class Vehicle(
    val id: Int,
    val lat: Double,
    val lon: Double,
    val fleetType: FleetType,
    val heading: Double
) : DomainEntity