package com.github.yusufyilmazfr.podcast4j.util

import org.junit.Assert
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
        Assert.assertEquals("", actualQueryParams)
    }

    @Test
    fun toQueryParams_returnNonNullQueryParams_whenParametersHaveNullValue() {
        // Arrange
        val map = HashMap<String, Any?>()
        map["firstName"] = "yusuf"
        map["lastName"] = "yilmaz"
        map["userName"] = "yusufyilmazfr"
        map["age"] = null

        val expectedQueryParameters = "firstName=yusuf&lastName=yilmaz&userName=yusufyilmazfr"

        // Actual
        val actualQueryParams = HttpRequestUtil.toQueryParams(map)

        // Assert
        Assert.assertEquals(expectedQueryParameters, actualQueryParams)
    }
}
