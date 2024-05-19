package sindri.lab.mvvmdagger2retrofitapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sindri.lab.mvvmdagger2retrofitapp.repository.ProductRepository
import javax.inject.Inject

class StartingViewModelFactory @Inject constructor(private val repository: ProductRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StartingViewModel(repository) as T
    }

}