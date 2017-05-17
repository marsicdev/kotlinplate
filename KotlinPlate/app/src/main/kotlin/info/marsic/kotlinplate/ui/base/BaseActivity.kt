package info.marsic.kotlinplate.ui.base

import android.annotation.TargetApi
import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.app.KotlinPlateApp
import info.marsic.kotlinplate.di.component.ActivityComponent
import info.marsic.kotlinplate.di.component.DaggerActivityComponent
import info.marsic.kotlinplate.di.module.ActivityModule
import info.marsic.kotlinplate.ui.login.LoginActivity
import info.marsic.kotlinplate.utils.showTransparentLoadingDialog

abstract class BaseActivity : AppCompatActivity(), MvpView, BaseFragment.Callback {

    private lateinit var progressDialog: ProgressDialog

    lateinit var activityComponent: ActivityComponent
        private set

    @get:LayoutRes
    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)

        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as KotlinPlateApp).component)
                .build()

    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
        hideLoading()
        progressDialog = showTransparentLoadingDialog()
    }

    override fun hideLoading() {
        if (progressDialog.isShowing) {
            progressDialog.cancel()
        }
    }

    override fun onError(message: String?) {
        val msgText = message ?: getString(R.string.error_general_title)
        showSnackBar(msgText)
    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }

    override fun onFragmentAttached() {}

    override fun onFragmentDetached(tag: String) {}

    override fun openActivityOnTokenExpire() {
        LoginActivity.start(this)
        finish()
    }

    val activeFragment: Fragment?
        get() {
            val fragmentManager = supportFragmentManager
            if (fragmentManager.backStackEntryCount == 0) {
                return null
            }
            val tag = fragmentManager
                    .getBackStackEntryAt(fragmentManager.backStackEntryCount - 1).name
            return fragmentManager.findFragmentByTag(tag)
        }

    protected abstract fun setupViews()

    protected fun replaceFragment(fragmentContainer: Int, fragment: Fragment, addToBackStack: Boolean = false) {
        val fragmentTag = fragment.javaClass.name

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentContainer, fragment, fragmentTag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.toString())
        }
        fragmentTransaction.commit()
    }

    protected fun findFragmentByTag(tag: String): Fragment {
        return supportFragmentManager
                .findFragmentByTag(tag)
    }
}
