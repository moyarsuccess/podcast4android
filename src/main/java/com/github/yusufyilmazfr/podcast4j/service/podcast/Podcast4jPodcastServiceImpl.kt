package com.github.yusufyilmazfr.podcast4j.service.podcast

import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg
import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast
import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast
import com.github.yusufyilmazfr.podcast4j.enums.MediumType
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.gson
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.*
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams
import okhttp3.Request

internal object Podcast4jPodcastServiceImpl : Podcast4jPodcastService {

    override fun getPodcastByFeedId(feedId: Int): Podcast? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/byfeedid?id=$feedId")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(
                response.body?.string(),
                PodcastResponse::class.java
            ).podcast
        }
    }

    override fun getPodcastByFeedURL(feedURL: String): Podcast? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/byfeedurl?url=$feedURL")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(response.body?.string(), PodcastResponse::class.java).podcast
        }
    }

    override fun getPodcastByGUID(GUID: String): Podcast? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/byguid?guid=$GUID")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(response.body?.string(), PodcastResponse::class.java).podcast
        }
    }

    override fun getPodcastByiTunesID(iTunesId: Long): Podcast? {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/byitunesid?id=$iTunesId")
            .build()
        return okHttpClient.newCall(request).execute().use { response ->
            val res = response.body?.string()
            println("WTF - $res")
            gson.fromJson(res, PodcastResponse::class.java).podcast
        }
    }

    override fun podcastsByTag(): List<Podcast> {
        val request: Request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/bytag?podcast-value")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(
                response.body?.string(),
                PodcastsByTagResponse::class.java
            ).podcasts ?: emptyList()
        }
    }

    override fun getPodcastsByMedium(mediumType: MediumType): List<Podcast> {
        val request: Request = HttpRequestUtil.with(config)
            .url(BASE_API_V1_URL + "/podcasts/bymedium?medium=" + mediumType.getName())
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(
                response.body?.string(),
                PodcastsByMediumResponse::class.java
            ).podcasts ?: emptyList()
        }
    }

    override fun getTrendPodcasts(arg: TrendPodcastsArg): List<TrendPodcast> {
        val queryParams = toQueryParams(arg.toParams())
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/trending?$queryParams")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(
                response.body?.string(),
                TrendPodcastsResponse::class.java
            ).trendPodcasts ?: emptyList()
        }
    }

    override fun deadPodcasts(): List<DeadPodcast> {
        val request: Request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/podcasts/dead")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(
                response.body?.string(),
                DeadPodcastsResponse::class.java
            ).deadPodcasts ?: emptyList()
        }
    }
}
