package com.golda.cleancodeproject.presentation.screen.vehicle.map

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.golda.cleancodeproject.R
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.presentation.base.BaseMvvmActivity
import com.golda.cleancodeproject.presentation.screen.vehicle.list.VehicleListFragment
import com.golda.cleancodeproject.presentation.screen.vehicle.list.VehicleListViewModel
import com.golda.cleancodeproject.presentation.screen.vehicle.list.VehicleListViewModelFactory

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class VehicleMapActivity : BaseMvvmActivity<VehicleListViewModel>(), OnMapReadyCallback,
    VehicleListFragment.OnVehicleClicked {
    private var map: GoogleMap? = null

    override fun provideLayoutId(): Int {
        return R.layout.activity_vehicle_maps
    }

    override fun provideViewModel(): VehicleListViewModel {
        return ViewModelProviders.of(this, VehicleListViewModelFactory())
            .get(VehicleListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        if (savedInstanceState == null) initList()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        map?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        map?.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        viewModel
            .vehicleClicked
            .observe(this, object : Observer<Vehicle> {
                override fun onChanged(vehicle: Vehicle?) {
                    if (vehicle != null) {
                        moveToVehicle(vehicle)
                    }
                }
            })
    }

    private fun moveToVehicle(vehicle: Vehicle) {
        val sydney = LatLng(vehicle.lat, vehicle.lon)
        map?.addMarker(MarkerOptions().position(sydney).title(vehicle.heading.toString()))
        map?.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f))
    }

    private fun initList() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, VehicleListFragment.getInstance())
        transaction.commit()
    }

    override fun onClick(objects: Vehicle) {
        moveToVehicle(objects)
    }
}
