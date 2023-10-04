package  com.eldmandate.todoapp.ui.first_scene

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.eldmandate.todoapp.model.ResponseItem
import com.eldmandate.todoapp.networkRepo.NetworkRepository
import com.eldmandate.todoapp.base.BaseViewModel
import com.eldmandate.todoapp.model.User
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