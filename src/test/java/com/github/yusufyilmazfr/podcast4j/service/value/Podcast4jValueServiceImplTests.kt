package com.github.yusufyilmazfr.podcast4j.service.value

import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.assertNotNull
import org.junit.Test

private const val PODCAST_INDEX_FEED_ID_FOR_VALUE = 920666
private const val PODCAST_INDEX_FEED_URL_FOR_VALUE = "https://mp3s.nashownotes.com/pc20rss.xml"

class Podcast4jValueServiceImplTests {

    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun getValueByFeedId_shouldReturnMatchedValue() {
        // Arrange
        val valueService = serviceFactory.valueService

        // Actual
        val value = valueService.getValueByFeedId(PODCAST_INDEX_FEED_ID_FOR_VALUE)

        // Assert
        assertNotNull(value)
        assertNotNull(value?.model)
        assertNotNull(value?.destinations)
    }

    @Test
    fun getValueByFeedURL_shouldReturnMatchedValue() {
        // Arrange
        val valueService = serviceFactory.valueService

        // Actual
        val value = valueService.getValueByFeedURL(PODCAST_INDEX_FEED_URL_FOR_VALUE)

        // Assert
        assertNotNull(value)
        assertNotNull(value?.model)
        assertNotNull(value?.destinations)
    }
}
