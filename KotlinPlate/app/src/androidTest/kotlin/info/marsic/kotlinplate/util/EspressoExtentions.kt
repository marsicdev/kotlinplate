package info.marsic.kotlinplate.util

import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.v7.widget.Toolbar
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull.notNullValue

// Ellen Shapiro: https://goo.gl/f8cPK1

// VIEWS

fun viewWithIdVisible(@IdRes resId: Int) {
    onView(withId(resId)).check(matches(notNullValue()))
    onView(withId(resId)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

fun viewWithIdHasIMEAction(@IdRes resId: Int, imeAction: Int) {
    onView(withId(resId)).check(matches(hasImeAction(imeAction)))
}

fun viewWithIdGone(@IdRes resId: Int) {
    onView(withId(resId)).check(matches(notNullValue()))
    onView(withId(resId)).check(matches(withEffectiveVisibility(Visibility.GONE)))
}

fun viewWithIdInvisible(@IdRes resId: Int) {
    onView(withId(resId)).check(matches(notNullValue()))
    onView(withId(resId)).check(matches(withEffectiveVisibility(Visibility.INVISIBLE)))
}

fun viewWithIdEnabled(@IdRes resId: Int, enabled: Boolean) {
    onView(withId(resId)).check(matches(enabledMatcher(enabled)))
}

fun viewWithIdAndTextVisible(@IdRes buttonId: Int, @StringRes textResString: Int) {
    onView(withId(buttonId)).check(matches(notNullValue()))
    onView(withId(buttonId)).check(matches(withText(textResString)))
    onView(withId(buttonId)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

fun viewWithIdAndHintVisible(@IdRes buttonId: Int, @StringRes hintResString: Int) {
    onView(withId(buttonId)).check(matches(notNullValue()))
    onView(withId(buttonId)).check(matches(withHint(hintResString)))
    onView(withId(buttonId)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

// TEXT ENTRY

fun typeTextIntoViewWithId(textToEnter: String, @IdRes viewId: Int) {
    onView(withId(viewId)).check(matches(notNullValue()))
    onView(withId(viewId)).perform(typeText(textToEnter))
}

fun typeTextIntoViewWithHint(textToEnter: String, @StringRes hintResString: Int) {
    onView(withHint(hintResString)).perform(typeText(textToEnter))
}

// SCROLLING

fun scrollToViewWithId(@IdRes viewIdRes: Int) {
    onView(withId(viewIdRes)).perform(scrollTo())
}

// TAPPING

fun tapViewWithText(text: String) {
    onView(withText(text)).perform(click())
}

fun tapViewWithText(@StringRes textResId: Int) {
    onView(withText(textResId)).perform(click())
}

fun tapViewWithId(@IdRes viewResId: Int) {
    onView(withId(viewResId)).perform(click())
}

// TOOLBAR

fun matchToolbarTitle(title: CharSequence): ViewInteraction {
    return onView(isAssignableFrom(Toolbar::class.java))
            .check(matches(withToolbarTitle(`is`(title))))
}

private fun withToolbarTitle(textMatcher: Matcher<CharSequence>): Matcher<Any> {
    return object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {
        public override fun matchesSafely(toolbar: Toolbar): Boolean {
            return textMatcher.matches(toolbar.title)
        }

        override fun describeTo(description: Description) {
            description.appendText("with toolbar title: ")
            textMatcher.describeTo(description)
        }
    }
}

private fun enabledMatcher(status: Boolean): Matcher<View> {
    return if (status) isEnabled() else not(isEnabled())
}
