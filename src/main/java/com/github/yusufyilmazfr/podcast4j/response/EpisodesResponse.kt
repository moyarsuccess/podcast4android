package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Episode
import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("items")
    val episodes: List<Episode>? = null,
    val query: String? = null
) : BaseResponse()
