package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Stats

data class StatsResponse(
    val stats: Stats? = null,
) : BaseResponse()
