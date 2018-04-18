package info.marsic.kotlinplate.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.ui.base.BaseFragment
import javax.inject.Inject

class AboutFragment : BaseFragment(), AboutContract.View {

    @Inject lateinit var presenter: AboutPresenter<AboutContract.View>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.about_fragment, container, false)
        activityComponent.inject(this)
        presenter.onAttach(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    //endregion

    override fun initViews(view: View?) {
        // Ignore
    }

    override fun showInitialView() {
        TODO("not implemented")
    }

    companion object {
        fun newInstance(aboutInfo: String): AboutFragment {
            val aboutFragment = AboutFragment()
            val bundleArgs = Bundle()
            bundleArgs.putSerializable("", aboutInfo)
            aboutFragment.arguments = bundleArgs
            return aboutFragment
        }
    }
}
