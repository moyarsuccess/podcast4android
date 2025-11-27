package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class DeadPodcast(
    /**
     * The internal PodcastIndex.org Feed ID.
     */
    val id: Int? = null,

    /**
     * Name of the feed
     */
    val title: String? = null,

    /**
     * Current feed URL
     */
    val url: URL? = null,

    /**
     * The internal PodcastIndex.org Feed ID this feed duplicates
     */
    val duplicateOf: Int? = null,
)
