package com.golda.cleancodeproject.data.repository.vehicle

import com.golda.cleancodeproject.data.BuildConfig
import com.golda.cleancodeproject.data.entity.vehicle.VehiclePoiResponse
import com.golda.cleancodeproject.data.entity.vehicle.transform
import com.golda.cleancodeproject.domain.entity.vehicle.CoordinateParam
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.domain.repository.vehicle.VehicleRepository
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.lang.Exception

class VehicleRepositoryRemote(private val url: String) : VehicleRepository {

    //private val CAR_SERVICE_URL = "kiparo.ru/t/fake-api/car-service.php"

    override fun fetch(param: CoordinateParam): Single<List<Vehicle>> {

        return Single.create<VehiclePoiResponse> { emitter ->
            try {
                val response = requestData(param)
                emitter.onSuccess(response)
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
        .map {vehiclePoi ->
            vehiclePoi.poiList.map {
                    vehicleResponse ->  vehicleResponse.transform()
            }
        }
    }

    @Throws(Exception::class)
    private fun requestData(param: CoordinateParam): VehiclePoiResponse {

        val httpUrlBuilder = HttpUrl.parse(url)?.newBuilder()
            ?: throw Exception("Incorrect URL")

        httpUrlBuilder.addQueryParameter("p1Lat", param.lat1.toString())
        httpUrlBuilder.addQueryParameter("p1Lon", param.lon1.toString())
        httpUrlBuilder.addQueryParameter("p2Lat", param.lat2.toString())
        httpUrlBuilder.addQueryParameter("p2Lon", param.lon2.toString())

        val clientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(loggingInterceptor)
        }
        val okhttp = clientBuilder.build()

        val request = Request.Builder()
            .url(httpUrlBuilder.build())
            .build()

        val response = okhttp.newCall(request).execute()

        val body = response.body()?.string()
            ?: throw Exception("Body is empty")

        val gson = Gson()
        val vehiclePoiResponse = gson
            .fromJson<VehiclePoiResponse>(body, VehiclePoiResponse::class.java)

        return vehiclePoiResponse
    }
}