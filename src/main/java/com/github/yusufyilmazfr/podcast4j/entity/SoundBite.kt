package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class SoundBite(
    val enclosureUrl: URL? = null,
    val title: String? = null,
    val startTime: Int = 0,
    val duration: Int = 0,
    val episodeId: Long = 0,
    val episodeTitle: String? = null,
    val feedTitle: String? = null,
    val feedUrl: URL? = null,
    val feedId: Int = 0,
)
