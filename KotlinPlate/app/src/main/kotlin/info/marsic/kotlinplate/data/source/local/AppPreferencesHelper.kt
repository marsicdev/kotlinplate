package info.marsic.kotlinplate.data.source.local

import android.content.Context
import info.marsic.kotlinplate.di.qualifier.ApplicationContext
import info.marsic.kotlinplate.di.qualifier.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferencesHelper @Inject
constructor(@ApplicationContext context: Context,
            @PreferenceInfo prefFileName: String) : PreferencesHelper {

    override var accessToken: String
        get() = TODO("not implemented")
        set(value) {}

    companion object {
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }
}