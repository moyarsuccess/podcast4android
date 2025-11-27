package com.github.yusufyilmazfr.podcast4j.service.recent

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.*
import org.junit.Test

class Podcast4jRecentServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun getFeeds_shouldReturnMatchedFeeds() {
        // Arrange
        val recentService = serviceFactory.recentService

        val arg = FeedsArg(
            max = 1,
            lang = "tr",
            cat = "technology",
        )

        // Actual
        val feeds = recentService.getFeeds(arg)

        // Assert
        assertNotNull(feeds)
        assertEquals(1, feeds.size.toLong())
        assertEquals("tr", feeds[0].language)
    }

    @Test
    fun getNewFeeds_shouldReturnMatchedNewFeeds() {
        // Arrange
        val recentService = serviceFactory.recentService

        val arg = NewFeedsArg(
            max = 1,
        )

        // Actual
        val feeds = recentService.getNewFeeds(arg)

        // Assert
        assertNotNull(feeds)
        assertEquals(1, feeds.size.toLong())
    }

    @Test
    fun getSoundBites_shouldReturnMatchedSoundBites() {
        // Arrange
        val recentService = serviceFactory.recentService
        val expectedSize = 5

        // Actual
        val soundBites = recentService.getSoundBites(expectedSize)

        // Assert
        assertNotNull(soundBites)
        assertEquals(expectedSize.toLong(), soundBites.size.toLong())
    }

    @Test
    fun getEpisodes_shouldReturnMatchedRecentEpisodes() {
        // Arrange
        val recentService = serviceFactory.recentService
        val excludedWord = "MP3"

        val arg = EpisodesArg(
            max = 1,
            excludeString = excludedWord,
        )

        // Actual
        val episodes = recentService.getEpisodes(arg)

        // Assert
        assertNotNull(episodes)
        assertEquals(1, episodes.size.toLong())
        assertFalse(
            episodes.stream().anyMatch { episode -> episode?.description?.contains(excludedWord) ?: false })
    }
}
