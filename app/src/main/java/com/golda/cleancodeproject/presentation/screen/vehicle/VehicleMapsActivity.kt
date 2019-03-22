package com.golda.cleancodeproject.presentation.screen.vehicle

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.golda.cleancodeproject.R
import com.golda.cleancodeproject.presentation.base.BaseMvvmActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class VehicleMapsActivity : BaseMvvmActivity<VehicleMapsViewModel>(), OnMapReadyCallback {
    override fun provideLayoutId(): Int {
        return R.layout.activity_vehicle_maps
    }

    override fun provideVievModel(): VehicleMapsViewModel {
       return ViewModelProviders.of(this, VehicleMapViewModelFactory()).get(VehicleMapsViewModel::class.java)
    }

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}