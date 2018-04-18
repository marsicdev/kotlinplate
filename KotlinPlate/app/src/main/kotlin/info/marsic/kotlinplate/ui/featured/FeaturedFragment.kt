package info.marsic.kotlinplate.ui.featured

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.ui.base.BaseFragment
import javax.inject.Inject

class FeaturedFragment : BaseFragment(), FeaturedContract.View {

    @Inject lateinit var presenter: FeaturedPresenter<FeaturedContract.View>

    //region Lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.featured_fragment, container, false)

        activityComponent.inject(this)
        presenter.onAttach(this)

        setHasOptionsMenu(true)

        return view
    }

    //endregion

    //region Base fragment
    override fun initViews(view: View?) {
        // Ignore
    }
    //endregion

    //region Featured View
    override fun showFeaturedData() {
        TODO("not implemented")
    }
    //endregion
}