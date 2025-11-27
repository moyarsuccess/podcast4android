package com.github.yusufyilmazfr.podcast4j.service.value

import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Value
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.objectMapper
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.ValueResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil

internal object Podcast4jValueServiceImpl : Podcast4jValueService {

    override fun getValueByFeedId(feedId: Int): Value? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/value/byfeedid?id=$feedId")
            .build()
        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(response.body?.string(), ValueResponse::class.java).value
        }
    }

    override fun getValueByFeedURL(feedURL: String): Value? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/value/byfeedurl?url=$feedURL")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(response.body?.string(), ValueResponse::class.java).value
        }
    }
}
