package info.marsic.kotlinplate.ui.featured

import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenMock

@RunWith(MockitoJUnitRunner::class)
class FeaturedPresenterTest {

    private val dataManager: DataManager = mock(DataManager::class.java)
    private val featuredView: FeaturedContract.View = mock(FeaturedContract.View::class.java)

    private var featuredPresenter: FeaturedPresenter<FeaturedContract.View> = FeaturedPresenter(dataManager, CompositeDisposable())

    @Before
    fun setUp() {
        verifyZeroInteractions(featuredView)
        featuredPresenter.onAttach(featuredView)
    }

    @After
    fun tearDown() {
        featuredPresenter.onDetach()
        verifyNoMoreInteractions(featuredView)
    }

    @Test
    @Throws(Exception::class)
    fun onLoad_shouldShowFeaturedData() {
        featuredPresenter.loadFeaturedData()

        verify(featuredView).showFeaturedData()
    }

    @Test(expected = BasePresenter.MvpViewNotAttachedException::class)
    @Throws(Exception::class)
    fun onViewNotAttached_shouldThrowMvpException() {
        featuredPresenter.onDetach()

        featuredPresenter.loadFeaturedData()

        verify(featuredView, never()).showFeaturedData()
    }

}