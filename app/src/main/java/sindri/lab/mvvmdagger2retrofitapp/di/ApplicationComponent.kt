package sindri.lab.mvvmdagger2retrofitapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import sindri.lab.mvvmdagger2retrofitapp.StartingActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {
    fun inject(startingActivity: StartingActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}