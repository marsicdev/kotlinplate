package info.marsic.kotlinplate.ui.home

import info.marsic.kotlinplate.di.qualifier.PerActivity
import info.marsic.kotlinplate.ui.base.MvpPresenter
import info.marsic.kotlinplate.ui.base.MvpView

interface HomeContract {

    interface View : MvpView {

        fun showFeaturedFragment()

        fun showAboutActivity()

        fun showSettingsActivity()

        fun raiseShareIntent()

        fun raiseRateIntent()

    }

    @PerActivity
    interface Presenter<in V : View> : MvpPresenter<V> {

        fun onViewInitialized()

        fun onNavigationFeaturedClick()

        fun onNavigationSettingsClick()

        fun onNavigationAboutClick()

        fun onNavigationShareClick()

        fun onNavigationRateClick()

    }
}
