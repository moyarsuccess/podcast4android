package com.github.yusufyilmazfr.podcast4j.service.stats

import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Stats
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.objectMapper
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.StatsResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil
import okhttp3.Request

internal object Podcast4jStatsServiceImpl : Podcast4jStatsService {

    override fun get(): Stats? {
        val request: Request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/stats/current")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(response.body?.string(), StatsResponse::class.java).stats
        }
    }
}
