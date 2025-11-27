package com.github.yusufyilmazfr.podcast4j.service.episode

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*
import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Episode
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.gson
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.ByGUIDEpisodeResponse
import com.github.yusufyilmazfr.podcast4j.response.EpisodeResponse
import com.github.yusufyilmazfr.podcast4j.response.EpisodesResponse
import com.github.yusufyilmazfr.podcast4j.response.RandomEpisodesResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams

internal object Podcast4jEpisodeServiceImpl : Podcast4jEpisodeService {

    override fun getEpisodeById(arg: ByIdArg): Episode? {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/byid?$queryParams"
        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return null
            gson.fromJson(response.body?.string(), EpisodeResponse::class.java).episode
        }
    }

    override fun getEpisodesByFeedId(arg: ByFeedIdArg): List<Episode> {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/byfeedid?$queryParams"

        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return emptyList()
            gson.fromJson(response.body?.string(), EpisodesResponse::class.java)?.episodes ?: emptyList()
        }
    }

    override fun getEpisodesByFeedURL(arg: ByFeedURLArg): List<Episode> {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/byfeedurl?$queryParams"

        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return emptyList()
            gson.fromJson(response.body?.string(), EpisodesResponse::class.java)?.episodes ?: emptyList()
        }
    }

    override fun getEpisodesByiTunesId(arg: ByiTunesArg): List<Episode> {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/byitunesid?$queryParams"

        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return emptyList()
            gson.fromJson(response.body?.string(), EpisodesResponse::class.java)?.episodes ?: emptyList()
        }
    }

    override fun getEpisodeByGUID(arg: ByGUIDArg): Episode? {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/byguid?$queryParams"

        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return null
            gson.fromJson(response.body?.string(), ByGUIDEpisodeResponse::class.java).episode
        }
    }

    override fun getLiveEpisodes(max: Int): List<Episode> {
        val url = "$BASE_API_V1_URL/episodes/live?max=$max"
        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return emptyList()
            gson.fromJson(response.body?.string(), EpisodesResponse::class.java)?.episodes ?: emptyList()
        }
    }

    override fun getRandomEpisodes(arg: RandomEpisodesArg): List<Episode> {
        val queryParams = toQueryParams(arg.toParams())
        val url = "$BASE_API_V1_URL/episodes/random?$queryParams"

        val request = HttpRequestUtil.with(config)
            .url(url)
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) return emptyList()
            gson.fromJson(response.body?.string(), RandomEpisodesResponse::class.java)?.episodes ?: emptyList()
        }
    }
}
