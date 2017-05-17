package info.marsic.kotlinplate.di.component

import dagger.Component
import info.marsic.kotlinplate.di.module.TestApiServiceModule
import info.marsic.kotlinplate.di.module.TestApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestApplicationModule::class, TestApiServiceModule::class))
interface TestApplicationComponent : ApplicationComponent
