package sindri.lab.mvvmdagger2retrofitapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import sindri.lab.mvvmdagger2retrofitapp.model.Product

@Dao
interface FakerDAO {

    @Insert
    suspend fun addProduct(products: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts(): List<Product>

}