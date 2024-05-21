package sindri.lab.mvvmdagger2retrofitapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import sindri.lab.mvvmdagger2retrofitapp.db.FakerDB
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDB(context: Context) : FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java,"FakerDB").build()
    }

}