package com.github.yusufyilmazfr.podcast4j.service.podcast

import com.github.yusufyilmazfr.podcast4j.arg.service.podcast.TrendPodcastsArg
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast
import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast
import com.github.yusufyilmazfr.podcast4j.enums.MediumType

interface Podcast4jPodcastService {
    fun getPodcastByFeedId(feedId: Int): Podcast?

    fun getPodcastByFeedURL(feedURL: String): Podcast?

    fun getPodcastByGUID(GUID: String): Podcast?

    fun getPodcastByiTunesID(iTunesId: Long): Podcast?

    fun podcastsByTag(): List<Podcast>

    fun getPodcastsByMedium(mediumType: MediumType): List<Podcast>

    fun getTrendPodcasts(arg: TrendPodcastsArg): List<TrendPodcast>

    fun deadPodcasts(): List<DeadPodcast>
}
