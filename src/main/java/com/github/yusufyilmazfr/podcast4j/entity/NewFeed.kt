package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class NewFeed(
    val id: Int = 0,
    val url: String? = null,
    val timeAdded: Long = 0,
    val status: String? = null,
    val contentHash: String? = null,
    val language: String? = null,
    val image: String? = null,
)
