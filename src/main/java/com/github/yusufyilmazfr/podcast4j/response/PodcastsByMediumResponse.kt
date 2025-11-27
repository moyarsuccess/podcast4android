package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.yusufyilmazfr.podcast4j.entity.Podcast

data class PodcastsByMediumResponse(
    @field:JsonProperty("feeds")
    val podcasts: MutableList<Podcast>? = null,
    val medium: String? = null
) : BaseResponse()
