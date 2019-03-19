package by.itacademy.cleancodeproject.presentation.test.mvvm

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import by.itacademy.cleancodeproject.R
import by.itacademy.cleancodeproject.app.UseCaseProvider
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_test_mvp_mvvm.*

class TestMvvmActivity : Activity() {

    private lateinit var viewModel: TestMvvmViewModel

    private val vehicleUseCase = UseCaseProvider.provideGetVehicleUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_mvp_mvvm)

        viewModel = TestMvvmViewModelDefault()

        viewModel.setHelloTextListener(object : HelloTextListener {
            override fun onUpdated(value: String) {
                helloTextView.text = value
            }
        })

        helloTextView.setOnClickListener {
            observeVehicle()
        }
    }

    private var disposable: Disposable? = null

    private fun observeVehicle() {

        disposable = vehicleUseCase
            .get()
            .subscribe({ list ->
                Toast.makeText(this, "list size " + list.size,
                    Toast.LENGTH_SHORT).show()
            }, { e ->
                Toast.makeText(this, "error " + e.toString(),
                    Toast.LENGTH_SHORT).show()
            })
    }

    override fun onResume() {
        super.onResume()
        viewModel.reloadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
