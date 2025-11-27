package com.github.yusufyilmazfr.podcast4j.response

abstract class BaseResponse(
    val count: Int = 0,
    val status: Boolean = false,
    val description: String? = null,
)
