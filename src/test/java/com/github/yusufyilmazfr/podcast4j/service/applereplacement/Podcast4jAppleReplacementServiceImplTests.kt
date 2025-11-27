package com.github.yusufyilmazfr.podcast4j.service.applereplacement

import com.github.yusufyilmazfr.podcast4j.constant.Constant.CODEFICTION_iTUNES_ID
import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class Podcast4jAppleReplacementServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun search_shouldReturnMatchedSearchResults() {
        // Arrange
        val appleReplacementService = serviceFactory.appleReplacementService

        // Actual
        val searches = appleReplacementService.search("batman")

        // Assert
        assertNotNull(searches)
        assertTrue(searches.isNotEmpty())
    }

    @Test
    fun lookup_shouldReturnMatchedSearchResults() {
        // Arrange
        val appleReplacementService = serviceFactory.appleReplacementService

        // Actual
        val searches = appleReplacementService.lookup(CODEFICTION_iTUNES_ID, "")

        // Assert
        assertNotNull(searches)
        assertTrue(searches.isNotEmpty())
    }
}
