package info.marsic.kotlinplate

import android.content.Context
import info.marsic.kotlinplate.app.KotlinPlateApp
import info.marsic.kotlinplate.data.DataManager
import info.marsic.kotlinplate.di.component.DaggerTestApplicationComponent
import info.marsic.kotlinplate.di.component.TestApplicationComponent
import info.marsic.kotlinplate.di.module.TestApplicationModule

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestComponentRule(val context: Context) : TestRule {

    lateinit var testComponent: TestApplicationComponent

    val dataManager: DataManager
        get() = testComponent.dataManager

    private fun setupDaggerTestComponentInApplication() {
        val application = context.applicationContext as KotlinPlateApp
        testComponent = DaggerTestApplicationComponent.builder()
                .testApplicationModule(TestApplicationModule(application))
                .build()
        application.component = testComponent
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    setupDaggerTestComponentInApplication()
                    base.evaluate()
                } finally {
                    // ignore
                }
            }
        }
    }
}