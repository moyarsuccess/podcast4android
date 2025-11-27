package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Podcast
import com.google.gson.annotations.SerializedName

data class PodcastsByMediumResponse(
    @SerializedName("feeds")
    val podcasts: MutableList<Podcast>? = null,
    val medium: String? = null
) : BaseResponse()
