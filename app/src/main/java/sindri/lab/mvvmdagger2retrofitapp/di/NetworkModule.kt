package sindri.lab.mvvmdagger2retrofitapp.di

import androidx.constraintlayout.widget.ConstraintSet.Constraint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sindri.lab.mvvmdagger2retrofitapp.retrofit.FakeAPI
import sindri.lab.mvvmdagger2retrofitapp.utils.Constants
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesFakeAPI(retrofit: Retrofit): FakeAPI{
        return retrofit.create(FakeAPI::class.java)
    }
}