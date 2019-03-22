package com.golda.cleancodeproject.data.repository

import com.golda.cleancodeproject.data.repository.vehicle.VehicleRepositoryRemote
import com.golda.cleancodeproject.domain.entity.vehicle.CoordinateParam
import org.junit.Test

class VehicleRepositoryRemoteTest {

    @Test
    fun testRealRequestComplete() {
        val url = "http://kiparo.ru/t/fake-api/car-service.php"
        val repository = VehicleRepositoryRemote(url)

        val coordinateParam = CoordinateParam(
            lat1 = 2.25,
            lon1 = 5.145,
            lat2 = 5.544,
            lon2 = 2.345)

        repository
            .fetch(coordinateParam)
            .test()
            .assertComplete()
    }
}