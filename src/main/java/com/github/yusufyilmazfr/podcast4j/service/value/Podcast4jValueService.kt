package com.github.yusufyilmazfr.podcast4j.service.value

import com.github.yusufyilmazfr.podcast4j.entity.Value

interface Podcast4jValueService {
    fun getValueByFeedId(feedId: Int): Value?
    fun getValueByFeedURL(feedURL: String): Value?
}
