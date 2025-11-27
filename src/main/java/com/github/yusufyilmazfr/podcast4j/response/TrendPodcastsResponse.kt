package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.TrendPodcast
import com.google.gson.annotations.SerializedName

class TrendPodcastsResponse(
    @SerializedName("feeds")
    val trendPodcasts: MutableList<TrendPodcast>? = null,
    val max: Int? = null,
    val since: Long? = null
) : BaseResponse()
