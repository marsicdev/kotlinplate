package info.marsic.kotlinplate.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.util.DisplayMetrics
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import info.marsic.kotlinplate.app.AppConfig
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

// View

@JvmOverloads
fun View.snackbar(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, length).show()
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

// Dialogs

fun Context.showTransparentLoadingDialog(): ProgressDialog {
    val progressDialog = ProgressDialog(this)
    progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small)
    progressDialog.show()
    return progressDialog
}

@SuppressLint("all")
fun Context.getDeviceId(): String {
    return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}

fun CharSequence.isValidAsEmail(): Boolean {
    val pattern: Pattern
    val matcher: Matcher
    val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    pattern = Pattern.compile(EMAIL_PATTERN)
    matcher = pattern.matcher(this)
    return matcher.matches()
}

fun CharSequence?.isValidEmail(): Boolean {
    return this != null && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun getTimestamp(): String {
    return SimpleDateFormat(AppConfig.TIMESTAMP_FORMAT, Locale.US).format(Date())
}

// Keyboard

fun Activity.hideSoftInput() {
    var view = currentFocus
    if (view == null) {
        view = View(this)
    }
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun EditText.showSoftInput() {
    this.isFocusable = true
    this.isFocusableInTouchMode = true
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}

fun Activity.toggleSoftInput() {
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

// Network

fun Context.isNetworkConnected(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}

// Screen

fun Context.getScreenWidth(): Int {
    val windowManager = this
            .getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.widthPixels
}

fun Context.getScreenHeight(): Int {
    val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    return dm.heightPixels
}

// View

fun Float.toDp(): Float {
    val densityDpi = Resources.getSystem().displayMetrics.densityDpi
    return this / (densityDpi / 160f)
}

fun Float.toPx(): Int {
    val density = Resources.getSystem().displayMetrics.density
    return Math.round(this * density)
}