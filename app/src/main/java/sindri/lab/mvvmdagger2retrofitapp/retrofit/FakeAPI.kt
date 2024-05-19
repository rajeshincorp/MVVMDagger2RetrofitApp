package sindri.lab.mvvmdagger2retrofitapp.retrofit

import retrofit2.Response
import retrofit2.http.GET
import sindri.lab.mvvmdagger2retrofitapp.model.Product

interface FakeAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>

}