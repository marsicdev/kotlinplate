package info.marsic.kotlinplate.ui.about

import info.marsic.kotlinplate.ui.base.MvpPresenter
import info.marsic.kotlinplate.ui.base.MvpView

interface AboutContract {

    interface View : MvpView {
        fun showInitialView()
    }

    interface Presenter<in V : View> : MvpPresenter<V> {
        fun onViewInitialized()
    }
}
