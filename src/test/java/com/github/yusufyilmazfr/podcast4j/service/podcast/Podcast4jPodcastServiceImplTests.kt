package com.github.yusufyilmazfr.podcast4j.service.podcast

import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_ID
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_URL
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_GUID_ID
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_PODCAST_TITLE
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_iTUNES_ID
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.github.yusufyilmazfr.podcast4j.enums.MediumType
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.*
import org.junit.Test

class Podcast4jPodcastServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun getPodcastByFeedId_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val podcast: Podcast? = podcastService.getPodcastByFeedId(CODEFICTION_FEED_ID)

        // Assert
        assertNotNull(podcast)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast?.title)
        assertEquals(CODEFICTION_iTUNES_ID, podcast?.itunesId)
    }

    @Test
    fun getPodcastByFeedURL_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val podcast: Podcast? = podcastService.getPodcastByFeedURL(CODEFICTION_FEED_URL)

        // Assert
        assertNotNull(podcast)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast?.title)
        assertEquals(CODEFICTION_FEED_URL, podcast?.url)
        assertEquals(CODEFICTION_iTUNES_ID, podcast?.itunesId)
    }


    @Test
    fun getPodcastByGUID_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val podcast: Podcast? = podcastService.getPodcastByGUID(CODEFICTION_GUID_ID)

        // Assert
        assertNotNull(podcast)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast?.title)
        assertEquals(CODEFICTION_FEED_URL, podcast?.url.toString())
        assertEquals(CODEFICTION_iTUNES_ID, podcast?.itunesId)
    }


    @Test
    fun getPodcastByiTunesID_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val podcast: Podcast? = podcastService.getPodcastByiTunesID(CODEFICTION_iTUNES_ID)

        // Assert
        assertNotNull(podcast)
        assertEquals(CODEFICTION_PODCAST_TITLE, podcast?.title)
        assertEquals(CODEFICTION_FEED_URL, podcast?.url.toString())
        assertEquals(CODEFICTION_iTUNES_ID, podcast?.itunesId)
    }


    @Test
    fun getPodcastsByTag_shouldReturnMatchedPodcasts() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        // [TODO] yusufyilmazfr: podcastindex response is not valid.
        // [TODO] yusufyilmazfr: If there are categories api provides a MAP but if there are no any categories api provides empty array?
        // [TODO] yusufyilmazfr: Array and MAP are different data type, so json mapper are not able to parse these.
        val podcasts = podcastService.podcastsByTag()

        // Assert
        assertNotNull(podcasts)
        assertTrue(podcasts.isNotEmpty())
    }

    @Test
    fun getPodcastsByMedium_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val podcasts = podcastService.getPodcastsByMedium(MediumType.MUSIC)

        // Assert
        assertNotNull(podcasts)
    }

    @Test
    fun getTrendPodcasts_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        val expectedMaxCount = 5
        val expectedLanguage = "en"
        val expectedCategory = "News"
        val expectedNotInCategory = "Entertainment"


        val arg = TrendPodcastsArg(
            lang = "en",
            cat = "News",
            notCat = "Entertainment",
            max = 5,
        )

        // Actual
        val trendPodcasts = podcastService.getTrendPodcasts(arg)
        val firstTrendPodcast = trendPodcasts[0]

        // Assert
        assertEquals(expectedMaxCount.toLong(), trendPodcasts.size.toLong())
        assertEquals(expectedLanguage, firstTrendPodcast.language)
        assertTrue(firstTrendPodcast.categories?.containsValue(expectedCategory) ?: false)
        assertFalse(firstTrendPodcast.categories?.containsValue(expectedNotInCategory) ?: true)
    }

    @Test
    fun getDeadPodcasts_shouldReturnMatchedPodcast() {
        // Arrange
        val podcastService = serviceFactory.podcastService

        // Actual
        val deadPodcasts = podcastService.deadPodcasts()

        // Assert
        assertNotNull(deadPodcasts)
    }
}
