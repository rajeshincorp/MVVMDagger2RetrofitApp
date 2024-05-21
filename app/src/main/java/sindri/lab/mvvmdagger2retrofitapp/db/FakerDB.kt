package sindri.lab.mvvmdagger2retrofitapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import sindri.lab.mvvmdagger2retrofitapp.model.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDAO() : FakerDAO

}