package sindri.lab.mvvmdagger2retrofitapp

import android.app.Application
import sindri.lab.mvvmdagger2retrofitapp.di.ApplicationComponent
import sindri.lab.mvvmdagger2retrofitapp.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder().build()
    }
}