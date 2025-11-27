package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Episode

data class ByGUIDEpisodeResponse(
    val id: Int? = null,
    val url: String? = null,
    val guid: String? = null,
    val podcastGuid: String? = null,
    val episode: Episode? = null,
) : BaseResponse()
