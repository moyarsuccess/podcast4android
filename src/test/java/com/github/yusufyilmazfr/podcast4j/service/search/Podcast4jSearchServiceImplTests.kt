package com.github.yusufyilmazfr.podcast4j.service.search

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_PODCAST_TITLE
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_iTUNES_ID
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class Podcast4jSearchServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun searchPodcastsByTerm_shouldReturnMatchedPodcasts() {
        // Arrange
        val searchService = serviceFactory.searchService

        val arg = SearchPodcastsByTermArg(
            q = CODEFICTION_PODCAST_TITLE,
        )

        // Actual
        val podcasts = searchService.searchPodcastsByTerm(arg)

        // Assert
        assertNotNull(podcasts)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcasts[0].title)
        assertEquals(CODEFICTION_iTUNES_ID, podcasts[0].itunesId)
    }

    @Test
    fun searchPodcastsByTitle_shouldReturnMatchedPodcasts() {
        // Arrange
        val searchService = serviceFactory.searchService

        val arg = SearchPodcastsByTitleArg(
            q = CODEFICTION_PODCAST_TITLE,
            similar = java.lang.Boolean.TRUE,
        )

        // Actual
        val podcasts = searchService.searchPodcastsByTitle(arg)

        // Assert
        assertNotNull(podcasts)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcasts[0].title)
        assertEquals(CODEFICTION_iTUNES_ID, podcasts[0].itunesId)
    }
}
