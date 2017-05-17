package info.marsic.kotlinplate.data

import android.content.Context
import info.marsic.kotlinplate.data.source.local.PreferencesHelper
import info.marsic.kotlinplate.data.source.network.ApiHelper
import info.marsic.kotlinplate.di.qualifier.ApplicationContext
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
internal constructor(@param:ApplicationContext private val context: Context,
                     private val preferencesHelper: PreferencesHelper,
                     private val apiHelper: ApiHelper) : DataManager {

    override var accessToken: String
        get() = preferencesHelper.accessToken
        set(token) {}

    override fun doRandomRequest(): Single<String> {
        return apiHelper.doRandomRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
