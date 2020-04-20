package com.dragonforest.app.kotlinstudy

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.dragonforest.app.kotlinstudy.kotlinclasstest.BaseAnimal
import com.dragonforest.app.kotlinstudy.kotlinclasstest.Bird
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.dragonforest.app.kotlinstudy", appContext.packageName)
    }

    @Test
    fun testClass(){
        var base=BaseAnimal()
        var bird=Bird()
        base.run()
        bird.run()
    }
}
