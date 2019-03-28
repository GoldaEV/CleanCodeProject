package com.golda.cleancodeproject.presentation.screen.vehicle.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.golda.cleancodeproject.R
import com.golda.cleancodeproject.domain.entity.vehicle.Vehicle
import com.golda.cleancodeproject.presentation.base.BaseMvvmFragment
import com.golda.cleancodeproject.presentation.screen.vehicle.list.adapter.VehicleListAdapter
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_vehicle_list.*

class VehicleListFragment : BaseMvvmFragment<VehicleListViewModel>() {

    companion object {
        fun getInstance() = VehicleListFragment()
    }

    private var vehicleStateDisposable: Disposable? = null

    override fun provideLayoutId() = R.layout.fragment_vehicle_list

    override fun provideViewModel(): VehicleListViewModel {
        return ViewModelProviders.of(activity!!, VehicleListViewModelFactory())
            .get(VehicleListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(bottomSheetLayout)
        view.post {
            behavior.peekHeight = resources.getDimensionPixelSize(R.dimen.vehicle_bottom_sheet_peek)
//            behavior.state = BottomSheetBehavior.STATE_HIDDEN                 ///----------------------------
        }
    }

    override fun initView() {
        observeVehicleState()
    }

//    private fun observeVehicleState() {
//        vehicleStateDisposable = viewModel
//            .vehicleState
//            .subscribe { state ->
//                processState(state)
//            }
//    }

    private fun observeVehicleState() {
            viewModel
            .vehicleState
            .observe(this, object : Observer<VehicleState> {
                override fun onChanged(state: VehicleState?) {
                    if(state != null) {
                        processState(state)
                    }
                }
            })
    }

    private fun processState(state: VehicleState) {

        when (state) {
            is VehicleState.Progress -> {
                // показываем прогресс
            }
            is VehicleState.Done -> {
                val list = state.vehicleList
                Toast.makeText(context, state.vehicleList.size.toString(), Toast.LENGTH_SHORT).show()
                // закидываем в adapter
                val layoutManager = LinearLayoutManager(context)
                recycleViewVehicle.layoutManager = layoutManager
                val decorator = DividerItemDecoration(context, layoutManager.orientation)
                recycleViewVehicle.addItemDecoration(decorator)
                recycleViewVehicle.adapter = VehicleListAdapter(list, {vehicleItem : Vehicle -> vehicleItemClicked(vehicleItem)})
                recycleViewVehicle.hasFixedSize()

            }
            is VehicleState.Error -> {
                val error = state.throwable
                Toast.makeText(
                    context, error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun vehicleItemClicked(item: Vehicle) {
        viewModel.vechicleClick(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        vehicleStateDisposable?.dispose()
    }
}