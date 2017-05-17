package info.marsic.kotlinplate.di.module

import dagger.Module
import dagger.Provides
import info.marsic.kotlinplate.data.source.network.RemoteApiService
import org.mockito.Mockito.mock

@Module
class TestApiServiceModule {

    @Provides
    internal fun apiService(): RemoteApiService {
        return mock<RemoteApiService>(RemoteApiService::class.java)
    }
}
