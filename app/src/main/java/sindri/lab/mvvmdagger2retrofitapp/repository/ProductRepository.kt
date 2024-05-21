package sindri.lab.mvvmdagger2retrofitapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Response
import sindri.lab.mvvmdagger2retrofitapp.db.FakerDB
import sindri.lab.mvvmdagger2retrofitapp.model.Product
import sindri.lab.mvvmdagger2retrofitapp.retrofit.FakeAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeAPI: FakeAPI,
    private val fakerDB: FakerDB) {

    private var _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>                    //exposed to outer world for access
        get() = _products

    suspend fun getProducts() {
        val result = fakeAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDAO().addProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }

}