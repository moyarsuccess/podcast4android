package com.github.yusufyilmazfr.podcast4j.service.applereplacement;

import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_APP_URL
import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.gson
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.AppleReplacementSearchResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil

internal object Podcast4jAppleReplacementServiceImpl : Podcast4jAppleReplacementService {

    override fun search(term: String): List<AppleReplacementSearch> {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_APP_URL/search?term=$term")
            .build()

        try {
            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) {
                return emptyList()
            }
            return gson
                .fromJson(response.body?.string(), AppleReplacementSearchResponse::class.java)
                .results
        } catch (_: Exception) {
            return emptyList()
        }
    }

    override fun lookup(iTunesId: Long, type: String): List<AppleReplacementSearch> {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_APP_URL/lookup?id=$iTunesId&entity=$type")
            .build()

        try {
            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) return emptyList()
            return gson
                .fromJson(response.body?.string(), AppleReplacementSearchResponse::class.java)
                .results
        } catch (_: Exception) {
            return emptyList()
        }
    }
}
