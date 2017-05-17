package info.marsic.kotlinplate.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import info.marsic.kotlinplate.app.AppConfig
import info.marsic.kotlinplate.app.KotlinPlateApp
import info.marsic.kotlinplate.data.AppDataManager
import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.data.source.local.AppPreferencesHelper
import info.marsic.kotlinplate.data.source.local.PreferencesHelper
import info.marsic.kotlinplate.data.source.network.ApiHelper
import info.marsic.kotlinplate.data.source.network.AppApiHelper
import info.marsic.kotlinplate.di.qualifier.ApplicationContext
import info.marsic.kotlinplate.di.qualifier.PreferenceInfo
import javax.inject.Singleton

@Module
class TestApplicationModule(private val mApplication: KotlinPlateApp) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): KotlinPlateApp {
        return mApplication
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConfig.PREF_NAME_KEY
    }

    // TODO : Mock all below for UI testing

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}
