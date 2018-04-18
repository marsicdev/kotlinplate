package info.marsic.kotlinplate.ui.home

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

class HomePresenterTest {

    private val dataManager: DataManager = mock(DataManager::class.java)
    private val homeView: HomeContract.View = mock(HomeContract.View::class.java)

    private val homePresenter: HomePresenter<HomeContract.View> = HomePresenter(dataManager, CompositeDisposable())

    @Before
    fun setUp() {
        verifyZeroInteractions(homeView)
        homePresenter.onAttach(homeView)
    }

    @After
    fun tearDown() {
        homePresenter.onDetach()
        verifyNoMoreInteractions(homeView)
    }

    @Test
    @Throws(Exception::class)
    fun onNavigationFeaturedSelected_shouldShowFeaturedFragment() {
        homePresenter.onNavigationFeaturedClick()

        verify(homeView).showFeaturedFragment()

    }

    @Test
    @Throws(Exception::class)
    fun onNavigationAboutSelected_shouldShowAboutActivity() {
        homePresenter.onNavigationAboutClick()

        verify(homeView).showAboutActivity()

    }

    @Test
    @Throws(Exception::class)
    fun onNavigationSettingsSelected_shouldShowSettingsActivity() {
        homePresenter.onNavigationSettingsClick()

        verify(homeView).showSettingsActivity()

    }

    @Test
    @Throws(Exception::class)
    fun onNavigationShareSelected_shouldRaiseShareIntent() {
        homePresenter.onNavigationShareClick()

        verify(homeView).raiseShareIntent()
    }

    @Test
    @Throws(Exception::class)
    fun onNavigationRateSelected_shouldRaiseRateIntent() {
        homePresenter.onNavigationRateClick()

        verify(homeView).raiseRateIntent()
    }

    @Test
    @Throws(Exception::class)
    fun onViewInitialized_shouldShowFeaturedFragment() {
        homePresenter.onViewInitialized()

        verify(homeView).showFeaturedFragment()
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException::class)
    @Throws(Exception::class)
    fun onViewNotAttached_shouldThrowMvpException() {
        homePresenter.onDetach()

        homePresenter.onViewInitialized()

        verify(homeView, never()).showFeaturedFragment()
    }
}