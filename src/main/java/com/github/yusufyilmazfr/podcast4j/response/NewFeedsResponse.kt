package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.NewFeed

data class NewFeedsResponse(
    val max: Int = 0,
    val feeds: List<NewFeed>? = null,
) : BaseResponse()
