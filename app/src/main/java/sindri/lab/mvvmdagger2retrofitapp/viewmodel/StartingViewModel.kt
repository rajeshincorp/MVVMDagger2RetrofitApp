package sindri.lab.mvvmdagger2retrofitapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sindri.lab.mvvmdagger2retrofitapp.model.Product
import sindri.lab.mvvmdagger2retrofitapp.repository.ProductRepository

class StartingViewModel(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}