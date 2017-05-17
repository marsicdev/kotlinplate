package info.marsic.kotlinplate.ui.login

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.clearText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.inputmethod.EditorInfo
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.util.*
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule @JvmField
    var loginActivityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun validate_loginScreenSetup() {

        viewWithIdVisible(R.id.action_bar_root)

        // Check for buttons
        viewWithIdVisible(R.id.titleTextView)
        viewWithIdVisible(R.id.subtitleTextView)

        // Check email EditText
        viewWithIdAndTextVisible(R.id.emailEditText, R.string.empty)
        viewWithIdAndHintVisible(R.id.emailEditText, R.string.hint_enter_email)
        viewWithIdHasIMEAction(R.id.emailEditText, EditorInfo.IME_ACTION_DONE)

        viewWithIdAndTextVisible(R.id.subscribeButton, R.string.action_subscribe)
        viewWithIdAndTextVisible(R.id.skipButton, R.string.action_skip)
    }

    @Test
    fun clickEnterButton_savesEmailAndShowsHomeUi() {

        // invalid email input
        viewWithIdEnabled(R.id.subscribeButton, false)
        typeTextIntoViewWithId("Invalid email", R.id.emailEditText)
        viewWithIdEnabled(R.id.subscribeButton, false)

        // valid email input
        onView(withId(R.id.emailEditText)).perform(clearText())
        typeTextIntoViewWithId("valid@mail.com", R.id.emailEditText)
        viewWithIdEnabled(R.id.subscribeButton, true)

        // button is enabled and can be clicked
        tapViewWithId(R.id.subscribeButton)

        // Shows home and displays welcome
        viewWithIdVisible(R.id.searchFab)

    }

    @Test
    fun clickContinueButton_showsHomeUi() {
        // click on the login button
        viewWithIdEnabled(R.id.skipButton, true)
        tapViewWithId(R.id.skipButton)

        // Shows home and displays
        viewWithIdVisible(R.id.searchFab)
    }

    @Test
    fun clickImeDoneButton_hideKeyboard() {
        tapViewWithId(R.id.emailEditText)
    }

    @Ignore
    fun clickAppInfo_displaysAppInfoDialog() {
        // Not ready yet
    }
}
