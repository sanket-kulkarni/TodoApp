package com.example.todoapp.ui.first_scene

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.adapter.UserListAdapterAdapter
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentFirstSceneBinding
import com.example.todoapp.listeners.UserAction
import com.example.todoapp.model.User
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