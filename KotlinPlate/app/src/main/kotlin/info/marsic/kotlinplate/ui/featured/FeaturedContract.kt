package info.marsic.kotlinplate.ui.featured

import info.marsic.kotlinplate.di.qualifier.PerActivity
import info.marsic.kotlinplate.ui.base.MvpPresenter
import info.marsic.kotlinplate.ui.base.MvpView

interface FeaturedContract {

    interface View : MvpView {

        fun showFeaturedData()
    }

    @PerActivity
    interface Presenter<in V : View> : MvpPresenter<V> {

        fun loadFeaturedData()
    }
}
