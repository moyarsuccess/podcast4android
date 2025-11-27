package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast

data class DeadPodcastsResponse(
    @field:JsonProperty("feeds")
    val deadPodcasts: List<DeadPodcast>? = null
) : BaseResponse()
