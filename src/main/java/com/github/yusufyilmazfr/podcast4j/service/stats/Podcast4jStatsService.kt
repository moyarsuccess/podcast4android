package com.github.yusufyilmazfr.podcast4j.service.stats

import com.github.yusufyilmazfr.podcast4j.entity.Stats

interface Podcast4jStatsService {
    fun get(): Stats?
}
