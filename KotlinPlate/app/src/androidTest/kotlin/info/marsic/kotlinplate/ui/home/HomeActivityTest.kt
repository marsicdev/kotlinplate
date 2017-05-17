package info.marsic.kotlinplate.ui.home

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import info.marsic.kotlinplate.R
import info.marsic.kotlinplate.util.viewWithIdVisible
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule @JvmField
    var activityActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    private val context: Context
        get() = InstrumentationRegistry.getTargetContext()

    @Test
    fun validate_homeActivitySetup() {
        viewWithIdVisible(R.id.toolbar)
        viewWithIdVisible(R.id.searchFab)
    }
}
