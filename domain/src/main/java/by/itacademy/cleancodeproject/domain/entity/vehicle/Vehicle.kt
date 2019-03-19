package by.itacademy.cleancodeproject.domain.entity.vehicle

import by.itacademy.cleancodeproject.domain.entity.DomainEntity

data class Vehicle(
    val id: Int,
    val lat: Double,
    val lon: Double,
    val fleetType: FleetType,
    val heading: Double
) : DomainEntity