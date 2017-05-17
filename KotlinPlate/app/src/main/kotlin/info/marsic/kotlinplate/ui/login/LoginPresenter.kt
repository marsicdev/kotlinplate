package info.marsic.kotlinplate.ui.login

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter<V : LoginContract.View> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable) : BasePresenter<V>(dataManager, compositeDisposable), LoginContract.Presenter<V> {

    override fun openApplicationInfo() {
        view.showAboutActivity()
    }

    override fun subscribeWithEmail() {
        // TODO: Should subscribe
        view.showHome()
    }

    override fun skipSubscription() {
        view.showHome()
    }
}
