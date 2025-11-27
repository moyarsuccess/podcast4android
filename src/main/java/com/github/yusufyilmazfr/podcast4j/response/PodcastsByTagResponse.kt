package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.yusufyilmazfr.podcast4j.entity.Podcast

data class PodcastsByTagResponse(
    @field:JsonProperty("feeds")
    val podcasts: List<Podcast>? = null,
) : BaseResponse()
