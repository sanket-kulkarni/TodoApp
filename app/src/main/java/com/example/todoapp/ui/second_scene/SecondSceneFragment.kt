package  com.example.todoapp.ui.second_scene

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.adapter.ResponseListAdapterAdapter
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentSecondSceneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondSceneFragment : BaseFragment<FragmentSecondSceneBinding, SecondSceneViewModel>() {

    override val layoutId: Int = R.layout.fragment_second_scene

    override val viewModel: SecondSceneViewModel by viewModels()

    private val navArgs by navArgs<SecondSceneFragmentArgs>()
    private val responseListAdapterAdapter: ResponseListAdapterAdapter by lazy {
        ResponseListAdapterAdapter(this.requireContext(), null, null)
    }

    override fun onReady(savedInstanceState: Bundle?) {
        binding.recyclerView.adapter = responseListAdapterAdapter
        if (navArgs.user != null)
            responseListAdapterAdapter.setLaunchesList(merge(navArgs.user?.completed!!, navArgs.user?.pending!!))
    }

}

fun <T> merge(first: List<T>, second: List<T>): List<T> {
    return first + second
}