package info.marsic.kotlinplate.ui.featured

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class FeaturedPresenter<V : FeaturedContract.View> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, compositeDisposable), FeaturedContract.Presenter<V> {

    override fun loadFeaturedData() {
        view.showFeaturedData()
    }
}
