package com.eldmandate.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eldmandate.todoapp.model.ResponseItem
import com.eldmandate.todoapp.R
import com.eldmandate.todoapp.BR
import com.eldmandate.todoapp.databinding.RowItemLayoutBinding
import com.eldmandate.todoapp.listeners.UserAction
import com.eldmandate.todoapp.model.User

class UserListAdapterAdapter(
    private val context: Context,
    userList: List<User>?,
    userAction: UserAction
) :
    RecyclerView.Adapter<UserListAdapterAdapter.ListViewHolder>() {
    private val userAction: UserAction
    private var itemList: List<User>?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding: RowItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_item_layout, parent, false
        )
        return ListViewHolder(binding, userAction)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item: User = itemList!![position]
        holder.bind(item)
        holder.rowItemLayoutBinding.getRoot().setOnClickListener(View.OnClickListener {
            userAction.onCardClick(
                item,
                holder.adapterPosition
            )
        })
    }

    fun setUserList(userList: List<User>?) {
        itemList = userList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (itemList != null) itemList!!.size else 0
    }

    class ListViewHolder(rowItemLayoutBinding: RowItemLayoutBinding, userAction: UserAction?) :
        RecyclerView.ViewHolder(rowItemLayoutBinding.getRoot()) {
        var rowItemLayoutBinding: RowItemLayoutBinding
        fun bind(obj: User?) {
            rowItemLayoutBinding.model = obj
            rowItemLayoutBinding.executePendingBindings()
        }

        init {
            this.rowItemLayoutBinding = rowItemLayoutBinding
        }
    }

    init {
        itemList = userList
        this.userAction = userAction
    }
}