package info.marsic.kotlinplate.ui.about

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.NavUtils
import android.support.v4.view.ViewPager
import android.view.MenuItem
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.ui.base.BaseActivity
import kotlinx.android.synthetic.main.about_activity.*
import kotlinx.android.synthetic.main.home_toolbar.*

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }

    override val layoutResource: Int
        get() = R.layout.about_activity

    override fun setupViews() {
        initToolbar()
        initViewPager(aboutViewPager)

        aboutTabLayout?.setupWithViewPager(aboutViewPager)
    }

    private fun initToolbar() {
        toolbar.title = getString(R.string.nav_about)
        toolbar.subtitle = getString(R.string.app_name)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViewPager(viewPager: ViewPager) {
        val adapter = AboutPagerAdapter(supportFragmentManager)
        adapter.addFragment(AboutFragment(), getString(R.string.about_tab_credits))
        adapter.addFragment(AboutFragment(), getString(R.string.about_tab_info))
        viewPager.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        return when (itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, AboutActivity::class.java)
            ActivityCompat.startActivity(activity, intent, null)
        }
    }
}
