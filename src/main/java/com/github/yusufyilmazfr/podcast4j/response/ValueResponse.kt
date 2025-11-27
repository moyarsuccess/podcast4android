package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Value

data class ValueResponse(
    val value: Value? = null,
    val query: MutableMap<String?, String?>? = null,
) : BaseResponse()
