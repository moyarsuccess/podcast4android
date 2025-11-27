package com.github.yusufyilmazfr.podcast4j

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg
import com.github.yusufyilmazfr.podcast4j.config.Config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory

fun main(args: Array<String>) {
    val service = Podcast4jServiceFactory.with(
        Config(
            authKey = "V7YV7YVH6QUE6CGDCZRJ",
            secret = "qx$" + "4Qr5mCb4aVfVc$" + "cNsq6mUEhEWjsBwt3vVxNNj",
            userAgentValue = "FreePodcast",
            timeOutValue = 10_000,
        )
    ).searchService
    val response = service.searchPodcastsByTitle(SearchPodcastsByTitleArg(q = "The Joe Rogan Experience"))
    println(response.joinToString(",") { it.author ?: "" })
}
