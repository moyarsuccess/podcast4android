package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.DeadPodcast
import com.google.gson.annotations.SerializedName

data class DeadPodcastsResponse(
    @SerializedName("feeds") val deadPodcasts: List<DeadPodcast>? = null
) : BaseResponse()
