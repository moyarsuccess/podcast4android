package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Feed

data class FeedsResponse(
    val feeds: MutableList<Feed>? = null,
    val max: Int? = null,
    val since: Long? = null,
) : BaseResponse()
