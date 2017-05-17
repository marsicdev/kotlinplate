package info.marsic.kotlinplate.ui.about

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AboutPresenter<V : AboutContract.View> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) :
        BasePresenter<V>(dataManager, compositeDisposable), AboutContract.Presenter<V> {

    override fun onViewInitialized() {
        view.showInitialView()
    }
}
