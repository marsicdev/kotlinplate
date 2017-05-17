package info.marsic.kotlinplate.ui.home

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter<V : HomeContract.View> @Inject
internal constructor(
        dataManager: DataManager,
        compositeDisposable: CompositeDisposable) :
        BasePresenter<V>(dataManager, compositeDisposable),
        HomeContract.Presenter<V> {

    override fun onNavigationFeaturedClick() {
        view.showFeaturedFragment()
    }

    override fun onNavigationSettingsClick() {
        view.showSettingsActivity()
    }

    override fun onNavigationAboutClick() {
        view.showAboutActivity()
    }

    override fun onNavigationShareClick() {
        view.raiseShareIntent()
    }

    override fun onNavigationRateClick() {
        view.raiseRateIntent()
    }

    override fun onViewInitialized() {
        view.showFeaturedFragment()
    }
}
