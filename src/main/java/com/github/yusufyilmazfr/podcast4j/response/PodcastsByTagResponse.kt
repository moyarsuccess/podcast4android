package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.google.gson.annotations.SerializedName

data class PodcastsByTagResponse(
    @SerializedName("feeds")
    val podcasts: List<Podcast>? = null,
) : BaseResponse()
