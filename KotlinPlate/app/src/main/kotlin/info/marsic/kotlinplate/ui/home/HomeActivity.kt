package info.marsic.kotlinplate.ui.home

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Animatable
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.ui.about.AboutActivity
import info.marsic.kotlinplate.ui.about.AboutFragment
import info.marsic.kotlinplate.ui.base.BaseActivity
import info.marsic.kotlinplate.utils.snackbar
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.home_app_bar.*
import kotlinx.android.synthetic.main.home_toolbar.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, HomeContract.View {

    @Inject lateinit var presenter: HomePresenter<HomeContract.View>

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent.inject(this)
        presenter.onAttach(this)

        setupViews()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(GravityCompat.START)!!) {
            drawerLayout?.closeDrawer(GravityCompat.START)
            return
        }
        super.onBackPressed()
    }
    //endregion

    //region BaseActivity
    override fun setupViews() {

        initToolbar()
        initNavigationDrawer()

        searchFab.setOnClickListener {
            it.snackbar("Not implemented")
        }

        presenter.onViewInitialized()
    }

    override val layoutResource: Int
        get() = R.layout.home_activity
    //endregion

    //region View actions
    override fun showFeaturedFragment() {
        val featuredFragment = AboutFragment()
        replaceFragment(R.id.frameContainer, featuredFragment)
    }

    override fun showAboutActivity() {
        AboutActivity.start(this)
    }

    override fun showSettingsActivity() {
        // TODO: "Not implemented"
    }

    override fun raiseShareIntent() {
        val target = Intent(Intent.ACTION_SEND)
        val intentChooser = Intent.createChooser(target, getString(R.string.text_share_app))

        target.type = "text/plain"
        target.putExtra(Intent.EXTRA_TITLE, getString(R.string.text_share_app_title))
        target.putExtra(Intent.EXTRA_TEXT, getString(R.string.url_play_store))
        startActivity(intentChooser)
    }

    override fun raiseRateIntent() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.url_play_store))))
        } catch (e: android.content.ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.url_market))))
        }
    }
    //endregion

    //region Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val drawable = item.icon
        if (drawable is Animatable) {
            drawable.start()
        }

        when (item.itemId) {
            R.id.nav_featured -> return true
            R.id.nav_about -> return true
            R.id.nav_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }
    //endregion

    //region Navigation listener
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val selectedMenuId = item.itemId

        when (selectedMenuId) {
            R.id.nav_featured -> presenter.onNavigationFeaturedClick()
            R.id.nav_about -> presenter.onNavigationAboutClick()
            R.id.nav_settings -> presenter.onNavigationSettingsClick()
            R.id.nav_share -> presenter.onNavigationShareClick()
            R.id.nav_rate -> presenter.onNavigationRateClick()
        }

        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }
    //endregion

    //region Helpers
    fun initToolbar() {
        toolbar.title = getString(R.string.nav_featured)
        toolbar.subtitle = getString(R.string.app_name)

        setSupportActionBar(toolbar)
    }

    fun initNavigationDrawer() {
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        navigationView?.setNavigationItemSelectedListener(this)
    }

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            ActivityCompat.startActivity(activity, intent, null)
            activity.finish()
        }
    }
    //endregion
}

