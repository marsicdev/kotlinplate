package info.marsic.kotlinplate.ui.base

import info.marsic.kotlinplate.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Base class that implements the MvpPresenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getView().
 */
open class BasePresenter<V : MvpView> @Inject constructor(
        protected val dataManager: DataManager,
        protected val compositeDisposable: CompositeDisposable) : MvpPresenter<V> {

    private var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }

    val view: V
        get() {
            checkViewAttached()
            return mvpView!!
        }

    override fun setUserAsLoggedOut() {
        dataManager.accessToken = "null"
    }

    private val isViewDetached: Boolean
        get() = mvpView == null

    private fun checkViewAttached() {
        if (isViewDetached) throw MvpViewNotAttachedException()
    }

    override fun handleApiError(error: Error) {}

    class MvpViewNotAttachedException internal constructor() : RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")
}
