package com.golda.cleancodeproject.presentation.screen.vehicle.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.golda.cleancodeproject.R
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle

class VehicleListAdapter(
    private val list: List<Vehicle>,
    private val clickListener: (Vehicle) -> Unit
): RecyclerView.Adapter<CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val returns = layoutInflater.inflate(R.layout.item_vehicle_list, parent, false)
        return CustomViewHolder(returns)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(list[position], clickListener)
    }
}