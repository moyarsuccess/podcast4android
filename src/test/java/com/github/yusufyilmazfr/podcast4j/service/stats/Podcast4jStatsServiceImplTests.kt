package com.github.yusufyilmazfr.podcast4j.service.stats

import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.assertNotNull
import org.junit.Test

class Podcast4jStatsServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun get_shouldReturnStatsAndCheckStatsPropertiesAreNotNull() {
        // Arrange
        val statsService = serviceFactory.statsService

        // Actual
        val stats = statsService.get()

        // Assert
        assertNotNull(stats)
        assertNotNull(stats?.feedCountTotal)
        assertNotNull(stats?.episodeCountTotal)
        assertNotNull(stats?.feedsWithNewEpisodes3days)
        assertNotNull(stats?.feedsWithNewEpisodes10days)
        assertNotNull(stats?.feedsWithNewEpisodes30days)
        assertNotNull(stats?.feedsWithNewEpisodes90days)
        assertNotNull(stats?.feedsWithValueBlocks)
    }
}
