package com.mytask.app.presentation.news_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mytask.app.R
import com.mytask.app.base.BaseViewModel
import com.mytask.app.base.MyDataBindingComponent
import com.mytask.app.databinding.FragmentNewsDetailBinding
import com.mytask.app.presentation.BaseFragment

class NewsDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentNewsDetailBinding
    private val args by navArgs<NewsDetailFragmentArgs>()
    private val dataBindingComponent = MyDataBindingComponent(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_news_detail,
                null,
                false,
                dataBindingComponent
            )
        binding.result = args.result
        return binding.root
    }

    override fun getViewModel(): BaseViewModel? {
        return null
    }

}