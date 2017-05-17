package info.marsic.kotlinplate.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import info.marsic.kotlinplate.di.component.ActivityComponent

abstract class BaseFragment : Fragment(), MvpView {

    var baseActivity: BaseActivity? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context
            this.baseActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun showLoading() {
        baseActivity?.showLoading()
    }

    override fun hideLoading() {
        baseActivity?.hideLoading()
    }

    override fun onError(message: String?) {
        baseActivity?.onError(message)
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun openActivityOnTokenExpire() {
        baseActivity?.openActivityOnTokenExpire()
    }

    val activityComponent: ActivityComponent
        get() = baseActivity?.activityComponent!!

    protected abstract fun initViews(view: View?)

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
