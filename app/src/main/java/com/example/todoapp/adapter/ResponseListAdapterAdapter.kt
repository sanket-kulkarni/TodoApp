package com.example.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.model.ResponseItem
import com.example.todoapp.R
import com.example.todoapp.databinding.RowItemTaskLayoutBinding
import com.example.todoapp.listeners.UserAction

class ResponseListAdapterAdapter(
    private val context: Context,
    responseList: List<ResponseItem>?,
    userAction: UserAction?
) :
    RecyclerView.Adapter<ResponseListAdapterAdapter.ListViewHolder>() {
    private val userAction: UserAction?
    private var itemList: List<ResponseItem>?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: RowItemTaskLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_item_task_layout, parent, false
        )
        return ListViewHolder(binding, userAction)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item: ResponseItem = itemList!![position]
        holder.bind(item)
    }

    fun setLaunchesList(responseList: List<ResponseItem>?) {
        itemList = responseList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (itemList != null) itemList!!.size else 0
    }

    class ListViewHolder(rowItemLayoutBinding: RowItemTaskLayoutBinding, userAction: UserAction?) :
        RecyclerView.ViewHolder(rowItemLayoutBinding.getRoot()) {
        var rowItemLayoutBinding: RowItemTaskLayoutBinding
        fun bind(obj: ResponseItem?) {
            rowItemLayoutBinding.model = obj
            rowItemLayoutBinding.executePendingBindings()
        }

        init {
            this.rowItemLayoutBinding = rowItemLayoutBinding
        }
    }

    init {
        itemList = responseList
        this.userAction = userAction
    }
}