package com.github.yusufyilmazfr.podcast4j.service.hub

import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_ID
import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_FEED_URL
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Test

class Podcast4jHubServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun notifyByFeedId_returnFalse_whenFeedIdIsNull() {
        // Arrange
        val feedId = 0
        val hubService = serviceFactory.hubService

        // Actual
        val actualResponse = hubService.notifyByFeedId(feedId)

        // Assert
        org.junit.Assert.assertFalse(actualResponse)
    }

    @Test
    fun notifyByFeedId_returnTrue_whenFeedIdIsValid() {
        // Arrange
        val hubService = serviceFactory.hubService

        // Actual
        val actualResponse = hubService.notifyByFeedId(CODEFICTION_FEED_ID)

        // Assert
        org.junit.Assert.assertTrue(actualResponse)
    }

    @Test
    fun notifyByFeedURL_returnFalse_whenFeedURLIsNull() {
        // Arrange
        val feedURL: kotlin.String? = null
        val hubService = serviceFactory.hubService

        // Actual
        val actualResponse = hubService.notifyByFeedURL(feedURL!!)

        // Assert
        org.junit.Assert.assertFalse(actualResponse)
    }

    @Test
    fun notifyByFeedURL_returnTrue_whenFeedURLIsValid() {
        // Arrange
        val hubService = serviceFactory.hubService

        // Actual
        val actualResponse = hubService.notifyByFeedURL(CODEFICTION_FEED_URL)

        // Assert
        org.junit.Assert.assertTrue(actualResponse)
    }
}
