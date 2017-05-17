package info.marsic.kotlinplate.di.component

import android.content.Context
import dagger.Component
import info.marsic.kotlinplate.app.KotlinPlateApp
import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.di.module.ApplicationModule
import info.marsic.kotlinplate.di.module.NetworkModule
import info.marsic.kotlinplate.di.qualifier.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun inject(application: KotlinPlateApp)

    @ApplicationContext
    fun context(): Context

    val application: KotlinPlateApp

    val dataManager: DataManager

}
