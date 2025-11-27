package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.AppleReplacementSearch
import lombok.Getter
import lombok.Setter

data class AppleReplacementSearchResponse(
    val resultCount: Int = 0,
    val results: List<AppleReplacementSearch> = emptyList(),
)
