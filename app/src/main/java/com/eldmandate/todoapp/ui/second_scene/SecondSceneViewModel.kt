package com.eldmandate.todoapp.ui.second_scene

import com.eldmandate.todoapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondSceneViewModel @Inject constructor() : BaseViewModel() {

    fun goBackClicked() {
        navigateBack()
    }
}