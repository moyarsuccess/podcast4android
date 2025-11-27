package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Episode

data class RandomEpisodesResponse(
    val episodes: MutableList<Episode>? = null,
    val max: Int? = null,
) : BaseResponse()
