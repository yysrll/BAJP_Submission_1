package com.yusril.bajp_submission_1.ui.home


import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private lateinit var instrumentalContext: Context

    @Before
    fun setUp() {
        instrumentalContext = InstrumentationRegistry.getInstrumentation().targetContext

        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(
            allOf(
                withId(R.id.rv_movies),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))

    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(
            allOf(
                withId(R.id.rv_movies),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadDetailMovie() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(allOf(withId(R.id.detail_activity), isDisplayed())).perform(swipeUp())
        onView(allOf(withId(R.id.img_poster), isDisplayed()))
        onView(allOf(withId(R.id.tv_year), isDisplayed()))
        onView(allOf(withId(R.id.tv_score), isDisplayed()))
        onView(allOf(withId(R.id.tv_language), isDisplayed()))
        onView(allOf(withId(R.id.tv_summary), isDisplayed()))
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(allOf(withId(R.id.detail_activity), isDisplayed())).perform(swipeUp())
        onView(allOf(withId(R.id.img_poster), isDisplayed()))
        onView(allOf(withId(R.id.tv_year), isDisplayed()))
        onView(allOf(withId(R.id.tv_score), isDisplayed()))
        onView(allOf(withId(R.id.tv_language), isDisplayed()))
        onView(allOf(withId(R.id.tv_summary), isDisplayed()))
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadFavoriteMovie() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_add)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favorite_menu)).perform(click())
        onView(allOf(withId(R.id.rv_favorite), isDisplayed()))
        onView(allOf(withId(R.id.rv_favorite), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_add)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(isRoot()).perform(pressBack())

    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_add)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favorite_menu)).perform(click())
        onView(withText("TV SHOWS")).perform(click())
        onView(allOf(withId(R.id.rv_favorite), isDisplayed()))
        onView(allOf(withId(R.id.rv_favorite), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fab_add)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(isRoot()).perform(pressBack())

    }
}