package sindri.lab.mvvmdagger2retrofitapp.di

import dagger.Component
import sindri.lab.mvvmdagger2retrofitapp.StartingActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(startingActivity: StartingActivity)
}