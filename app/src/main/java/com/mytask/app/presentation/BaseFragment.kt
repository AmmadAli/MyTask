package com.mytask.app.presentation

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mytask.app.base.BaseViewModel
import com.mytask.app.domain.usecase.base.Outcome
import com.mytask.app.presentation.main.MainActivity

abstract class BaseFragment : Fragment() {
    private var baseViewModel: BaseViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        baseViewModel = getViewModel()
        baseViewModel?.outcomeLiveData?.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Outcome.Start -> {
                    (activity as MainActivity).showProgressLoader(true)
                }
                is Outcome.End -> {
                    (activity as MainActivity).showProgressLoader(false)
                }
                is Outcome.Failure -> {
                    Toast.makeText(
                        activity,
                        "Some error occurred, Please try later",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is Outcome.NetworkError -> {
                    Toast.makeText(
                        activity,
                        "Please check your internet and try later",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        })
    }

    abstract fun getViewModel(): BaseViewModel?
}