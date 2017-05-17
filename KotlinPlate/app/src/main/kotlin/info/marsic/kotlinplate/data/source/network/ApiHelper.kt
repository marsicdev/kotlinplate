package info.marsic.kotlinplate.data.source.network

import io.reactivex.Single

interface ApiHelper {

    fun doRandomRequest(): Single<String>

}
