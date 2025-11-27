package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast
import lombok.Getter
import lombok.Setter

@Getter
@Setter
class TrendPodcastsResponse(
    @field:JsonProperty("feeds")
    val trendPodcasts: MutableList<TrendPodcast>? = null,
    val max: Int? = null,
    val since: Long? = null
) : BaseResponse()
