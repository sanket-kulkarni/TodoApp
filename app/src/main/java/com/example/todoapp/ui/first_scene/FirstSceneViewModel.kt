package  com.example.todoapp.ui.first_scene

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapp.model.ResponseItem
import com.example.todoapp.networkRepo.NetworkRepository
import com.example.todoapp.base.BaseViewModel
import com.example.todoapp.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstSceneViewModel  @Inject constructor(
    private val repository: NetworkRepository
) : BaseViewModel() {
    val responseList= MutableLiveData<List<ResponseItem>>()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            responseList.postValue(repository.getResponse())
        }
    }

    fun goToSecondFragmentWithArgs(user: User) {
        navigate(
            FirstSceneFragmentDirections.actionFirstSceneFragmentToSecondSceneFragment(
                user = user
            )
        )
    }
}