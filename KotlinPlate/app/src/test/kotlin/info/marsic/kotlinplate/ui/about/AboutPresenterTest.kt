package info.marsic.kotlinplate.ui.about

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenMock

class AboutPresenterTest {

    private val dataManager: DataManager = mock(DataManager::class.java)
    private val aboutView: AboutContract.View = mock(AboutContract.View::class.java)

    private val aboutPresenter: AboutPresenter<AboutContract.View> = AboutPresenter(dataManager, CompositeDisposable())

    @Before
    @Throws(Exception::class)
    fun setUp() {
        verifyZeroInteractions(aboutView)
        aboutPresenter.onAttach(aboutView)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        aboutPresenter.onDetach()
        verifyNoMoreInteractions(aboutView)
    }

    @Test
    @Throws(Exception::class)
    fun onViewInitialized_shouldShowInfoFragment() {
        aboutPresenter.onViewInitialized()

        verify(aboutView).showInitialView()
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException::class)
    @Throws(Exception::class)
    fun onViewNotAttached_shouldThrowMvpException() {
        aboutPresenter.onDetach()

        aboutPresenter.onViewInitialized()

        verify(aboutView, never()).showInitialView()
    }
}
