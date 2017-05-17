package info.marsic.kotlinplate.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import info.marsic.kotlinplate.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivity.start(this)
    }
}
