package com.github.yusufyilmazfr.podcast4j.service.search

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg
import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.gson
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.SearchPodcastsResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.toQueryParams
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil.with

internal object Podcast4jSearchServiceImpl : Podcast4jSearchService {

    override fun searchPodcastsByTerm(arg: SearchPodcastsByTermArg): List<Podcast> {
        val queryParams = toQueryParams(arg.toParams())
        val request = with(config)
            .url("$BASE_API_V1_URL/search/byterm?$queryParams")
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            return gson.fromJson(response.body?.string(), SearchPodcastsResponse::class.java).podcasts
                ?: emptyList()
        }
    }


    override fun searchPodcastsByTitle(arg: SearchPodcastsByTitleArg): List<Podcast> {
        val queryParams = toQueryParams(arg.toParams())
        val request = with(config)
            .url("$BASE_API_V1_URL/search/bytitle?$queryParams")
            .build()

        return okHttpClient.newCall(request).execute().use { response ->
            gson.fromJson(response.body?.string(), SearchPodcastsResponse::class.java).podcasts ?: emptyList()
        }
    }
}
