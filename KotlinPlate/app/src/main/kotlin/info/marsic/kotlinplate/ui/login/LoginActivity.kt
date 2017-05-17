package info.marsic.kotlinplate.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.text.Editable
import android.text.TextWatcher
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.ui.base.BaseActivity
import info.marsic.kotlinplate.ui.home.HomeActivity
import info.marsic.kotlinplate.utils.isValidAsEmail
import kotlinx.android.synthetic.main.login_activity.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject lateinit var presenter: LoginPresenter<LoginContract.View>

    // Lifecycle

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

    // Base Activity

    override val layoutResource: Int
        get() = R.layout.login_activity

    override fun setupViews() {
        skipButton?.setOnClickListener {
            presenter.skipSubscription()
        }

        subscribeButton?.setOnClickListener {
            presenter.subscribeWithEmail()
        }

        emailEditText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(emailSequence: CharSequence?, start: Int, before: Int, count: Int) {
                subscribeButton?.isEnabled = emailSequence?.isValidAsEmail()!!
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    // View interface implementation

    override fun showAboutActivity() {
        TODO("Not implemented")
    }

    override fun showHome() {
        HomeActivity.start(this)
    }

    companion object {

        fun start(activity: Activity) {
            val nextIntent = Intent(activity, LoginActivity::class.java)
            nextIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            ActivityCompat.startActivity(activity, nextIntent, null)
            activity.finish()
        }
    }
}
