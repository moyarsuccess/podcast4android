package com.github.yusufyilmazfr.podcast4j.service.episode

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODIFICATION_EPISODE_ID
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODIFICATION_FEED_ID
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODIFICATION_FEED_URL
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODIFICATION_ITUNES_ID
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.entity.Episode
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.*
import org.junit.Test

class Podcast4jEpisodeServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun getEpisodesByFeedId_shouldReturnMatchedEpisodes() {
        // Arrange
        val episodeService = serviceFactory.episodeService

        val arg = ByFeedIdArg(
            id = CODIFICATION_FEED_ID,
            max = 10,
        )

        // Actual
        val episodes = episodeService.getEpisodesByFeedId(arg)

        // Assert
        assertNotNull(episodes)
        assertEquals(10, episodes.size.toLong())
        assertEquals(CODIFICATION_FEED_ID, episodes[0].feedId)
    }

    @Test
    fun getEpisodesByFeedURL_shouldReturnMatchedEpisodes() {
        // Arrange
        val episodeService = serviceFactory.episodeService

        val arg = ByFeedURLArg(
            url = CODIFICATION_FEED_URL,
            max = 10,
        )

        // Actual
        val episodes = episodeService.getEpisodesByFeedURL(arg)

        // Assert
        assertNotNull(episodes)
        assertEquals(10, episodes.size.toLong())
        assertEquals(CODIFICATION_FEED_ID, episodes[0].feedId)
    }

    @Test
    fun getEpisodesByiTunesId_shouldReturnMatchedEpisodes() {
        // Arrange
        val episodeService = serviceFactory.episodeService

        val arg = ByiTunesArg(
            id = CODIFICATION_ITUNES_ID,
            max = 10,
        )

        // Actual
        val episodes = episodeService.getEpisodesByiTunesId(arg)

        // Assert
        assertNotNull(episodes)
        assertEquals(10, episodes.size.toLong())
        assertEquals(CODIFICATION_FEED_ID, episodes[0].feedId)
    }

    @Test
    fun getEpisodesByGUID_shouldReturnMatchedEpisode() {
        // Arrange
        val episodeService = serviceFactory.episodeService
        val expectedGUID = "PC2084"
        val expectedFeedId = 920666

        val arg = ByGUIDArg(
            guid = expectedGUID,
            feedId = expectedFeedId,
        )

        // Actual
        val episode = episodeService.getEpisodeByGUID(arg)

        // Assert
        assertNotNull(episode)
        assertEquals(expectedGUID, episode?.guid)
        assertEquals(expectedFeedId, episode?.feedId)
    }

    @Test
    fun getEpisodeById_shouldReturnMatchedEpisodes() {
        // Arrange
        val episodeService = serviceFactory.episodeService

        val arg = ByIdArg(
            id = CODIFICATION_EPISODE_ID,
            fulltext = java.lang.Boolean.TRUE
        )

        // Actual
        val episode = episodeService.getEpisodeById(arg)

        // Assert
        assertNotNull(episode)
        assertEquals(CODIFICATION_FEED_ID, episode?.feedId)
    }

    @Test
    fun getLiveEpisodes_shouldReturnMatchedEpisodes() {
        // Arrange
        val episodeService = serviceFactory.episodeService

        // Actual
        val episodes = episodeService.getLiveEpisodes(5)

        // Assert
        assertNotNull(episodes)
        assertNotEquals(0, episodes.size.toLong())
    }
}
