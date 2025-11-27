package com.github.yusufyilmazfr.podcast4j.service.recent

import com.github.yusufyilmazfr.podcast4j.arg.service.recent.EpisodesArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.FeedsArg
import com.github.yusufyilmazfr.podcast4j.arg.service.recent.NewFeedsArg
import com.github.yusufyilmazfr.podcast4j.entity.Episode
import com.github.yusufyilmazfr.podcast4j.entity.Feed
import com.github.yusufyilmazfr.podcast4j.entity.NewFeed
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite

interface Podcast4jRecentService {
    fun getFeeds(arg: FeedsArg): List<Feed>

    fun getNewFeeds(arg: NewFeedsArg): List<NewFeed>

    fun getSoundBites(max: Int): List<SoundBite>

    fun getEpisodes(arg: EpisodesArg): List<Episode>
}
