package com.golda.cleancodeproject.presentation.screen.vehicle.list

import android.arch.lifecycle.MutableLiveData
import com.golda.cleancodeproject.domain.entity.AppExaption
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.domain.usecase.vehicle.GetVehicleUseCase
import com.golda.cleancodeproject.presentation.base.BaseViewModel

class VehicleListViewModel(vehicleUseCase: GetVehicleUseCase) : BaseViewModel() {

//    val vehicleState = PublishSubject.create<VehicleState>()
    val vehicleState = MutableLiveData<VehicleState>()

    val vehicleClicked = MutableLiveData<Vehicle>()

    init {

//        vehicleState.onNext(VehicleState.Progress)
        vehicleState.value = VehicleState.Progress

        val disposable = vehicleUseCase
            .get()
            .subscribe({
//                vehicleState.onNext(VehicleState.Done(it))
                vehicleState.value = VehicleState.Done(it)
            }, {
                if (it is AppExaption) {
                    it.type
                    // Обработка ошибки которые брошены с VehicleRepositoryRemote -> AppExaption(ExaptionType.NO_INTERNET)

                }
                //vehicleState.onNext(VehicleState.Error(it))
                vehicleState.value = VehicleState.Error(it)
            })
        disposables.add(disposable)
    }

    fun vechicleClick(vehicle: Vehicle) {
        vehicleClicked.value = vehicle
    }
}