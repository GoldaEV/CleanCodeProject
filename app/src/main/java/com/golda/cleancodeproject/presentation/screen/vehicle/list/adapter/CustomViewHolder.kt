package com.golda.cleancodeproject.presentation.screen.vehicle.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import kotlinx.android.synthetic.main.item_vehicle_list.view.*


class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Vehicle, clickListener: (Vehicle) -> Unit) {
        view.name_item.text = "${item.id}  ${item.fleetType}"
        view.setOnClickListener{clickListener(item)}
    }
}