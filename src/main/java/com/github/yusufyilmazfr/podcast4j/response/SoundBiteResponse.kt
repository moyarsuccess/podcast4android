package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.SoundBite
import com.google.gson.annotations.SerializedName

data class SoundBiteResponse(
    @SerializedName("items")
    val soundBites: MutableList<SoundBite>? = null
) : BaseResponse()
