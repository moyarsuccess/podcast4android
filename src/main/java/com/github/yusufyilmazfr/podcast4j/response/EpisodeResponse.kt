package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Episode

data class EpisodeResponse(
    val episode: Episode?,
    val id: Int,
) : BaseResponse()
