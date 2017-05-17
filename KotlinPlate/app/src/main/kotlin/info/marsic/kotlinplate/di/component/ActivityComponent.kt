package info.marsic.kotlinplate.di.component

import dagger.Component
import info.marsic.kotlinplate.di.module.ActivityModule
import info.marsic.kotlinplate.di.qualifier.PerActivity
import info.marsic.kotlinplate.ui.about.AboutFragment
import info.marsic.kotlinplate.ui.featured.FeaturedFragment
import info.marsic.kotlinplate.ui.home.HomeActivity
import info.marsic.kotlinplate.ui.login.LoginActivity

@PerActivity
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent : ApplicationComponent {

    fun inject(loginActivity: LoginActivity)

    fun inject(homeActivity: HomeActivity)

    fun inject(featuredFragment: FeaturedFragment)

    fun inject(aboutFragment: AboutFragment)

}
