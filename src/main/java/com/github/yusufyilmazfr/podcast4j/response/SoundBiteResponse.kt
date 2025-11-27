package com.github.yusufyilmazfr.podcast4j.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.yusufyilmazfr.podcast4j.entity.SoundBite

data class SoundBiteResponse(
    @field:JsonProperty("items")
    val soundBites: MutableList<SoundBite>? = null
) : BaseResponse()
