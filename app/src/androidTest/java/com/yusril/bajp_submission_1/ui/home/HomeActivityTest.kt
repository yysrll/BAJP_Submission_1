package com.yusril.bajp_submission_1.ui.home


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.yusril.bajp_submission_1.R
import com.yusril.bajp_submission_1.utils.DataDummy
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(
            allOf(
                withId(R.id.rv_movies),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size - 1))

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
        onView(allOf(withId(R.id.img_poster), isDisplayed())).check(
            matches(
                withContentDescription(
                    dummyMovies[0].poster.toString()
                )
            )
        )
        onView(allOf(withId(R.id.tv_year), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_year),
                isDisplayed()
            )
        ).check(matches(withText(dummyMovies[0].year.toString())))
        onView(allOf(withId(R.id.tv_score), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_score),
                isDisplayed()
            )
        ).check(matches(withText("${dummyMovies[0].score.toString()}/100")))
        onView(allOf(withId(R.id.tv_language), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_language),
                isDisplayed()
            )
        ).check(matches(withText(dummyMovies[0].language)))
        onView(allOf(withId(R.id.tv_duration), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_duration),
                isDisplayed()
            )
        ).check(matches(withText(dummyMovies[0].duration)))
        onView(allOf(withId(R.id.tv_summary), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_summary),
                isDisplayed()
            )
        ).check(matches(withText(dummyMovies[0].summary)))
        onView(isRoot()).perform(pressBack())
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
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size - 1))
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
        onView(allOf(withId(R.id.img_poster), isDisplayed())).check(
            matches(
                withContentDescription(
                    dummyTvShows[0].poster.toString()
                )
            )
        )
        onView(allOf(withId(R.id.tv_year), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_year),
                isDisplayed()
            )
        ).check(matches(withText(dummyTvShows[0].year.toString())))
        onView(allOf(withId(R.id.tv_score), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_score),
                isDisplayed()
            )
        ).check(matches(withText("${dummyTvShows[0].score.toString()}/100")))
        onView(allOf(withId(R.id.tv_language), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_language),
                isDisplayed()
            )
        ).check(matches(withText(dummyTvShows[0].language)))
        onView(allOf(withId(R.id.tv_duration), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_duration),
                isDisplayed()
            )
        ).check(matches(withText(dummyTvShows[0].duration)))
        onView(allOf(withId(R.id.tv_summary), isDisplayed()))
        onView(
            allOf(
                withId(R.id.tv_summary),
                isDisplayed()
            )
        ).check(matches(withText(dummyTvShows[0].summary)))
        onView(isRoot()).perform(pressBack())
    }
}