package com.golda.cleancodeproject.presentation.screen.vehicle.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.golda.cleancodeproject.R
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.presentation.screen.vehicle.list.VehicleListFragment

class VehicleListAdapter(val context: Context, val list1: List<Vehicle>): RecyclerView.Adapter<VehicleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        return RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_vehicle_list, parent, false))
    }

    override fun getItemCount(): Int {
        return list1.size
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {

    }
}