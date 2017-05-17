package info.marsic.kotlinplate.ui.login

import info.marsic.kotlinplate.di.qualifier.PerActivity
import info.marsic.kotlinplate.ui.base.MvpPresenter
import info.marsic.kotlinplate.ui.base.MvpView

interface LoginContract {

    interface View : MvpView {

        fun showAboutActivity()

        fun showHome()

    }

    @PerActivity
    interface Presenter<in V : View> : MvpPresenter<V> {

        fun openApplicationInfo()

        fun subscribeWithEmail()

        fun skipSubscription()

    }

}
