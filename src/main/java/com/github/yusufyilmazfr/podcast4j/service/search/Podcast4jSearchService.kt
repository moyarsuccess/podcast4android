package com.github.yusufyilmazfr.podcast4j.service.search

import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTermArg
import com.github.yusufyilmazfr.podcast4j.arg.service.search.SearchPodcastsByTitleArg
import com.github.yusufyilmazfr.podcast4j.entity.Podcast

interface Podcast4jSearchService {
    fun searchPodcastsByTerm(arg: SearchPodcastsByTermArg): List<Podcast>
    fun searchPodcastsByTitle(arg: SearchPodcastsByTitleArg): List<Podcast>
}
