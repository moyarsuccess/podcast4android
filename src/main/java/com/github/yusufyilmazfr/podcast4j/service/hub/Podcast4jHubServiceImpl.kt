package com.github.yusufyilmazfr.podcast4j.service.hub

import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil

internal object Podcast4jHubServiceImpl : Podcast4jHubService {

    override fun notifyByFeedId(feedId: Int): Boolean {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/hub/pubnotify?id=$feedId")
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            return response.isSuccessful
        }
    }

    override fun notifyByFeedURL(feedURL: String): Boolean {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/hub/pubnotify?url=$feedURL")
            .build()

        okHttpClient.newCall(request).execute().use { response ->
            return response.isSuccessful
        }
    }
}
