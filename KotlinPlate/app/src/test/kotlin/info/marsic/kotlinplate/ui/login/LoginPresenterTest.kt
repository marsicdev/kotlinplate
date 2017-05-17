package info.marsic.kotlinplate.ui.login

import info.marsic.kotlinplate.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    internal val dataManager: DataManager = mock(DataManager::class.java)
    internal val loginView: LoginContract.View = mock(LoginContract.View::class.java)

    internal val loginPresenter: LoginPresenter<LoginContract.View> = LoginPresenter(dataManager, CompositeDisposable())

    @Before
    fun setUp() {
        verifyZeroInteractions(loginView)
        loginPresenter.onAttach(loginView)
    }

    @After
    fun tearDown() {
        loginPresenter.onDetach()
        verifyNoMoreInteractions(loginView)
    }

    @Test
    @Throws(Exception::class)
    fun onSubscribeClick_shouldSubscribeAndOpenHome() {
        loginPresenter.subscribeWithEmail()

        verify(loginView)?.showHome()
    }

    @Test
    @Throws(Exception::class)
    fun onSkipClick_shouldSkipSubscriptionAndOpenHome() {
        loginPresenter.skipSubscription()

        verify(loginView)?.showHome()
    }

    @Test
    @Throws(Exception::class)
    fun clickInfoIcon_shouldShowApplicationInfoDialog() {
        loginPresenter.openApplicationInfo()

        verify(loginView)?.showAboutActivity()
    }
}
