package com.github.yusufyilmazfr.podcast4j.service.recent

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg
import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Episode
import com.github.yusufyilmazfr.podcast4j.entity.Feed
import com.github.yusufyilmazfr.podcast4j.entity.NewFeed
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.objectMapper
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.EpisodesResponse
import com.github.yusufyilmazfr.podcast4j.response.FeedsResponse
import com.github.yusufyilmazfr.podcast4j.response.NewFeedsResponse
import com.github.yusufyilmazfr.podcast4j.response.SoundBiteResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams
import okhttp3.Request

internal object Podcast4jRecentServiceImpl : Podcast4jRecentService {

    override fun getFeeds(arg: FeedsArg): List<Feed> {
        val queryParams = toQueryParams(arg.toParams())

        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/recent/feeds?$queryParams")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(response.body?.string(), FeedsResponse::class.java).feeds
                ?: emptyList()
        }
    }

    override fun getNewFeeds(arg: NewFeedsArg): List<NewFeed> {
        val queryParams = toQueryParams(arg.toParams())
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/recent/newfeeds?$queryParams")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(response.body?.string(), NewFeedsResponse::class.java).feeds
                ?: emptyList()
        }
    }

    override fun getSoundBites(max: Int): List<SoundBite> {
        val request: Request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/recent/soundbites?max=$max")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(
                response.body?.string(),
                SoundBiteResponse::class.java
            ).soundBites ?: emptyList()
        }
    }

    override fun getEpisodes(arg: EpisodesArg): List<Episode> {
        val queryParams = toQueryParams(arg.toParams())
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/recent/episodes?$queryParams")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            objectMapper.readValue(
                response.body?.string(),
                EpisodesResponse::class.java
            ).episodes ?: emptyList()
        }
    }
}
