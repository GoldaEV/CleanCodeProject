package com.golda.cleancodeproject.data.db

import androidx.room.*
import com.golda.cleancodeproject.data.entity.vehicle.VehicleResponse
import io.reactivex.Completable
import io.reactivex.Single

@Dao
internal interface VehicleDao {

    @Query("SELECT * FROM VehicleTable")
    fun get(): Single<List<VehicleResponse>>

    @Query("SELECT * FROM VehicleTable WHERE id =:idVehicle LIMIT 1")
    fun getById(idVehicle: Int): Single<List<VehicleResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(vehicles: List<VehicleResponse>): Completable


    @Delete
    fun delete(): Completable
}