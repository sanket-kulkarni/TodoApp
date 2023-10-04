package com.eldmandate.todoapp.ui.first_scene

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.eldmandate.todoapp.adapter.ResponseListAdapterAdapter
import com.eldmandate.todoapp.R
import com.eldmandate.todoapp.adapter.UserListAdapterAdapter
import com.eldmandate.todoapp.base.BaseFragment
import com.eldmandate.todoapp.databinding.FragmentFirstSceneBinding
import com.eldmandate.todoapp.listeners.UserAction
import com.eldmandate.todoapp.model.ResponseItem
import com.eldmandate.todoapp.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstSceneFragment : BaseFragment<FragmentFirstSceneBinding, FirstSceneViewModel>(), UserAction {

    override val layoutId: Int = R.layout.fragment_first_scene

    override val viewModel: FirstSceneViewModel by viewModels()

    private val userListAdapterAdapter: UserListAdapterAdapter by lazy {
        UserListAdapterAdapter(this.requireContext(), null, this)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = userListAdapterAdapter
        viewModel.responseList.observe(this,
            androidx.lifecycle.Observer {
                val userList = mutableListOf<User>()
                it.groupBy { item ->  item.userId } .forEach {
                println("onReady : ${it.key} : ${it.value}")
                    userList.add(User(it.key,
                        it.value.filter { compltedItem -> compltedItem.completed == true },
                        it.value.filter { compltedItem -> compltedItem.completed == false }
                    ))
                }
                userListAdapterAdapter.setUserList(userList)
            })

    }

    override fun onCardClick(user: User, index: Int) {
        println("onCardClick : ${user.userId}")
        viewModel.goToSecondFragmentWithArgs(user)
    }
}