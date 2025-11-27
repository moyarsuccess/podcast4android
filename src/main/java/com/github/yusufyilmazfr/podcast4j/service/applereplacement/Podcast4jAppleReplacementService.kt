package com.github.yusufyilmazfr.podcast4j.service.applereplacement

import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch

/**
 * Replaces the Apple search API but returns data from the Podcast Index database.
 * Note: No API key needed for this endpoint.
 * <p>
 * Apple: <a href="https://itunes.apple.com/search?media=podcast&entity=podcast&term=batman">search on Apple</a>
 * PodcastIndex: <a href="https://api.podcastindex.org/search?term=batman">search on PodcastIndex</a>
 */
interface Podcast4jAppleReplacementService {
    fun search(term: String): List<AppleReplacementSearch>

    fun lookup(iTunesId: Long, type: String): List<AppleReplacementSearch>
}
