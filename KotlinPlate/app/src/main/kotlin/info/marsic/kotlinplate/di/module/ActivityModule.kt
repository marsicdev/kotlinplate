package info.marsic.kotlinplate.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import info.marsic.kotlinplate.di.qualifier.ActivityContext
import io.reactivex.disposables.CompositeDisposable


@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

}
