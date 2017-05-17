package info.marsic.kotlinplate.data.source.network

import io.reactivex.Single
import java.lang.UnsupportedOperationException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject
internal constructor(private val apiService: RemoteApiService) : ApiHelper {

    override fun doRandomRequest(): Single<String> {
        throw UnsupportedOperationException("not implemented")
    }

}
