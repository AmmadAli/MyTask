package com.mytask.app.presentation.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mytask.app.R
import com.mytask.app.base.BaseViewModel
import com.mytask.app.base.MyDataBindingComponent
import com.mytask.app.databinding.FragmentNewsListBinding
import com.mytask.app.presentation.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class NewsListFragment : BaseFragment() {

    private val newsListViewModel: NewsListViewModel by viewModel()
    private lateinit var newsListAdapter: NewsListAdapter
    private lateinit var binding: FragmentNewsListBinding
    private var dataBindingComponent = MyDataBindingComponent(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!this::binding.isInitialized) {
            binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_news_list, null, false)
            newsListAdapter = NewsListAdapter(dataBindingComponent) {
                val action =
                    NewsListFragmentDirections.actionNewsListFragmentToNewsDetailFragment(it)
                findNavController().navigate(action)
            }
            binding.rvNewsList.layoutManager =
                LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            binding.rvNewsList.adapter = newsListAdapter
            addObservers()
        }
        return binding.root
    }

    override fun getViewModel(): BaseViewModel? {
        return newsListViewModel
    }

    private fun addObservers() {

        newsListViewModel.getNewsListLiveData().observe(viewLifecycleOwner, Observer { resultList ->
            resultList?.let {
                newsListAdapter.submitList(it)
            }
        })
        newsListViewModel.fetchNewsList()
    }
}