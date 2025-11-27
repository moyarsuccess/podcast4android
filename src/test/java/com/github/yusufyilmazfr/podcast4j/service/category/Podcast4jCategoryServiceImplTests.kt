package com.github.yusufyilmazfr.podcast4j.service.category

import com.github.yusufyilmazfr.podcast4j.constant.testConfig
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class Podcast4jCategoryServiceImplTests {
    private val serviceFactory: Podcast4jServiceFactory = Podcast4jServiceFactory.with(testConfig)

    @Test
    fun getAll_shouldReturnAllCategory() {
        // Arrange
        val categoryService = serviceFactory.categoryService

        // Actual
        val categories = categoryService.all()

        // Assert
        assertNotNull(categories)
        assertNotEquals(0, categories!!.size.toLong())
    }
}
