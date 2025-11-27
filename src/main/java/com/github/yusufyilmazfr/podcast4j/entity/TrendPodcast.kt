package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class TrendPodcast(
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
     * The channel-level description
     * Uses the longest of the possible fields in the feed: <description>, <itunes:summary> and <content:encoded>
    </content:encoded></itunes:summary></description> */
    val description: String? = null,

    /**
     * The channel-level author element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    val author: String? = null,

    /**
     * The channel-level image element.
     */
    val image: URL? = null,

    /**
     * Seemingly the best artwork we can find for the feed. Might be the same as image in most instances.
     */
    val artwork: URL? = null,

    /**
     * The iTunes ID of this feed if there is one, and we know what it is.
     */
    val itunesId: Long? = null,

    /**
     * The ranking for how the podcast is trending in the index
     */
    val trendScore: Int? = null,

    /**
     * The channel-level language specification of the feed. Languages accord with the RSS Language Spec.
     */
    val language: String? = null,

    /**
     * The date and time the most recent episode in the feed was published
     */
    val newestItemPublishTime: Long? = null,

    /**
     * An array of categories, where the index is the Category ID and the value is the Category Name.
     */
    val categories: MutableMap<Int?, String?>? = null,
)