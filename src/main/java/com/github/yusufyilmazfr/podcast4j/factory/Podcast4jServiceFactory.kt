package com.github.yusufyilmazfr.podcast4j.factory

import com.github.yusufyilmazfr.podcast4j.config.Config
import com.github.yusufyilmazfr.podcast4j.constant.Constant
import com.github.yusufyilmazfr.podcast4j.service.applereplacement.Podcast4jAppleReplacementService
import com.github.yusufyilmazfr.podcast4j.service.applereplacement.Podcast4jAppleReplacementServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryService
import com.github.yusufyilmazfr.podcast4j.service.category.Podcast4jCategoryServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.episode.Podcast4jEpisodeService
import com.github.yusufyilmazfr.podcast4j.service.episode.Podcast4jEpisodeServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.hub.Podcast4jHubService
import com.github.yusufyilmazfr.podcast4j.service.hub.Podcast4jHubServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.podcast.Podcast4jPodcastService
import com.github.yusufyilmazfr.podcast4j.service.podcast.Podcast4jPodcastServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentService
import com.github.yusufyilmazfr.podcast4j.service.recent.Podcast4jRecentServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.search.Podcast4jSearchService
import com.github.yusufyilmazfr.podcast4j.service.search.Podcast4jSearchServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsService
import com.github.yusufyilmazfr.podcast4j.service.stats.Podcast4jStatsServiceImpl
import com.github.yusufyilmazfr.podcast4j.service.value.Podcast4jValueService
import com.github.yusufyilmazfr.podcast4j.service.value.Podcast4jValueServiceImpl
import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.net.Proxy
import java.net.URI
import java.util.concurrent.TimeUnit
import java.util.function.Supplier

object Podcast4jServiceFactory {
    lateinit var categoryService: Podcast4jCategoryService
    lateinit var statsService: Podcast4jStatsService
    lateinit var recentService: Podcast4jRecentService
    lateinit var episodeService: Podcast4jEpisodeService
    lateinit var podcastService: Podcast4jPodcastService
    lateinit var valueService: Podcast4jValueService
    lateinit var hubService: Podcast4jHubService
    lateinit var appleReplacementService: Podcast4jAppleReplacementService
    lateinit var searchService: Podcast4jSearchService
    internal lateinit var config: Config
    internal val gson: Gson by lazy {
        synchronized(this) {
            Gson()
        }
    }

    internal val okHttpClient: OkHttpClient by lazy {
        synchronized(OkHttpClient::class.java) {
            val builder = OkHttpClient.Builder()
                .followRedirects(false)
                .followSslRedirects(false)
                .connectTimeout(config.getTimeOut().toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(config.getTimeOut().toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(config.getTimeOut().toLong(), TimeUnit.MILLISECONDS)
            val proxySelector = config.proxySelector
            if (proxySelector != null) {
                val uri = URI(Constant.BASE_API_V1_URL)
                val proxies = proxySelector.select(uri)
                val proxy = proxies.firstOrNull()
                if (proxy != null && proxies !== Proxy.NO_PROXY) {
                    builder.proxy(proxies.firstOrNull())
                }
            }
            builder.build()
        }
    }

    fun with(config: Config): Podcast4jServiceFactory {
        this.config = config
        categoryService = Podcast4jCategoryServiceImpl
        statsService = Podcast4jStatsServiceImpl
        recentService = Podcast4jRecentServiceImpl
        episodeService = Podcast4jEpisodeServiceImpl
        podcastService = Podcast4jPodcastServiceImpl
        valueService = Podcast4jValueServiceImpl
        hubService = Podcast4jHubServiceImpl
        appleReplacementService = Podcast4jAppleReplacementServiceImpl
        searchService = Podcast4jSearchServiceImpl
        return this
    }

    fun with(supplier: Supplier<Config?>): Podcast4jServiceFactory {
        return with(requireNotNull(supplier.get()))
    }
}
