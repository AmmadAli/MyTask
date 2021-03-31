package com.mytask.app.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytask.app.R
import com.mytask.app.util.gone
import com.mytask.app.util.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showProgressLoader(show: Boolean) {
        if (show) {
            fl_progress_loader.visible()
        } else {
            fl_progress_loader.gone()
        }
    }
}
