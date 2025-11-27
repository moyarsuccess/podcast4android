package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.github.yusufyilmazfr.podcast4j.util.PodcastDeserializer

data class PodcastResponse(
    @field:JsonProperty("feed")
    @field:JsonDeserialize(using = PodcastDeserializer::class)
    val podcast: Podcast? = null
) : BaseResponse()
