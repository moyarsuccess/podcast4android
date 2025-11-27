package com.github.yusufyilmazfr.podcast4j.entity

data class Stats(
    val feedCountTotal: Int? = null,
    val episodeCountTotal: Int? = null,
    val feedsWithNewEpisodes3days: Int? = null,
    val feedsWithNewEpisodes10days: Int? = null,
    val feedsWithNewEpisodes30days: Int? = null,
    val feedsWithNewEpisodes90days: Int? = null,
    val feedsWithValueBlocks: Int? = null,
)
