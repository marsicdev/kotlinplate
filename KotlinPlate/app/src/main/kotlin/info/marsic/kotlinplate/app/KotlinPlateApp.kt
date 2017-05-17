package info.marsic.kotlinplate.app

import android.app.Application
import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.di.component.ApplicationComponent
import info.marsic.kotlinplate.di.component.DaggerApplicationComponent
import info.marsic.kotlinplate.di.module.ApplicationModule
import info.marsic.kotlinplate.di.module.NetworkModule
import javax.inject.Inject

open class KotlinPlateApp : Application() {

    lateinit var instance: KotlinPlateApp

    // Needed to replace the component with a test specific one
    lateinit var component: ApplicationComponent

    @Inject lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupDaggerAppComponent()
    }

    private fun setupDaggerAppComponent() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()

        component.inject(this)
    }

}
