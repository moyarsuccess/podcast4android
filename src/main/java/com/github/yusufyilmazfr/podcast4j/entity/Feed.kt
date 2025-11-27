package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class Feed(
    val id: Int? = null,
    val url: URL? = null,
    val title: String? = null,
    val newestItemPublishTime: Long? = null,
    val oldestItemPublishTime: Long? = null,
    val description: String? = null,
    val image: URL? = null,
    val itunesId: String? = null,
    val language: String? = null,
    val categories: MutableMap<Int?, String?>? = null,
)
