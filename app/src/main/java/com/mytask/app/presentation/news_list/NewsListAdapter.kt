package com.mytask.app.presentation.news_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.mytask.app.R
import com.mytask.app.base.BaseListAdapter
import com.mytask.app.data.models.Result
import com.mytask.app.databinding.ItemNewListBinding


class NewsListAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val clickListener: (result: Result) -> Unit
) : BaseListAdapter<Result, ItemNewListBinding>(
    diffCallback = diffCallback
) {


    override fun createBinding(parent: ViewGroup, viewType: Int): ItemNewListBinding {

        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_new_list,
            parent,
            false,
            dataBindingComponent
        )
    }

    override fun bind(binding: ItemNewListBinding, item: Result, position: Int) {
        binding.result = item
        binding.root.setOnClickListener {
            clickListener(item)
        }

    }

}

private val diffCallback: DiffUtil.ItemCallback<Result> =
    object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.title == newItem.title
        }
    }
