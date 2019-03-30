package com.golda.cleancodeproject.data.entity.vehicle

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "VehicleTable")
internal class VehicleResponse(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded
    val coordinate: CoordinateResponse,

    val fleetType: String,

    val heading: Double
)