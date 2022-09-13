package com.nameless.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.nameless.di.koinModules
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

class NavigationTest : KoinTest, KoinComponent {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(koinModules)
        }
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavHost(navController = navController)
        }
    }

    @After
    fun teardown() {
        stopKoin()
    }

    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule
            .onNodeWithText("5 Day Forecast")
            .assertIsDisplayed()
    }

    // TODO: the test below will require either using actual network, or implementing
    //  a fake api service here either locally or through koin - saving some time by using network

    @Test
    fun appNavHost_verifyDetailDestination() {
        composeTestRule
            .onNodeWithText("City or ZIP")
            .performTextInput("Detroit")

        composeTestRule.waitForIdle()

        composeTestRule
            .onNodeWithText("Detroit")
            .performImeAction()

        composeTestRule.waitUntil {
            composeTestRule.onAllNodesWithTag("forecastList")
                .fetchSemanticsNodes().isNotEmpty()
        }

        composeTestRule.waitForIdle()

        composeTestRule
            .onAllNodesWithTag("forecastList")
            .onLast()
            .performClick()

        val route = navController.currentBackStackEntry?.destination?.route
        assertThat(route, equalTo("detail/{cityZip}/{dayId}"))
        val cityZip = navController.currentBackStackEntry?.arguments?.getString("cityZip")
        val dayId = navController.currentBackStackEntry?.arguments?.getInt("dayId")
        assertThat(cityZip, equalTo("Detroit"))
        assert(dayId != null)
    }

}