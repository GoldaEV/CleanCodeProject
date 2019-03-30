package com.golda.cleancodeproject.data.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.golda.cleancodeproject.data.entity.vehicle.CoordinateResponse
import com.golda.cleancodeproject.data.entity.vehicle.VehicleResponse

abstract class AppDataBase: RoomDatabase() {
    companion object {
        private val dbName = "VehicleDB"

        fun create(context: Context): AppDataBase {
             return Room.databaseBuilder(context, AppDataBase::class.java, dbName).build()
        }
    }

     abstract fun getVehicleDao()

}