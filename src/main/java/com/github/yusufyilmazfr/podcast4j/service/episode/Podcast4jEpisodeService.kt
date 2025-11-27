package com.github.yusufyilmazfr.podcast4j.service.episode

import com.github.yusufyilmazfr.podcast4j.arg.service.episode.*
import com.github.yusufyilmazfr.podcast4j.entity.Episode

interface Podcast4jEpisodeService {
    fun getEpisodeById(arg: ByIdArg): Episode?
    fun getEpisodesByFeedId(arg: ByFeedIdArg): List<Episode>
    fun getEpisodesByFeedURL(arg: ByFeedURLArg): List<Episode>
    fun getEpisodesByiTunesId(arg: ByiTunesArg): List<Episode>
    fun getEpisodeByGUID(arg: ByGUIDArg): Episode?
    fun getLiveEpisodes(max: Int): List<Episode>
    fun getRandomEpisodes(arg: RandomEpisodesArg): List<Episode>
}
