package com.github.yusufyilmazfr.podcast4j.util

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Map

class HttpRequestUtilTests {
    @Test
    fun toQueryParams_returnEmptyQuery_whenParametersAreEmpty() {
        // Arrange
        val map = Map.of<String, Any?>()

        // Actual
        val actualQueryParams = HttpRequestUtil.toQueryParams(map)

        // Assert
        assertEquals("", actualQueryParams)
    }

    @Test
    fun toQueryParams_returnNonNullQueryParams_whenParametersHaveNullValue() {
        // Arrange
        val map = HashMap<String, Any?>()
        map["firstName"] = "Moyar"
        map["lastName"] = "Moradyar"
        map["userName"] = "moyarsuccess"
        map["age"] = null

        val expectedQueryParameters = "firstName=Moyar&lastName=Moradyar&userName=moyarsuccess"

        // Actual
        val actualQueryParams = HttpRequestUtil.toQueryParams(map)

        // Assert
        assertEquals(expectedQueryParameters, actualQueryParams)
    }
}
