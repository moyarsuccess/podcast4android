package com.github.yusufyilmazfr.podcast4j.arg.service.episode

data class ByGUIDArg(
    /**
     * (Required) The guid value for the episode to retrieve.
     * This value is the value specified in the feed's `<guid>` field.
    </guid> */
    val guid: String? = null,

    /**
     * The PodcastIndex Feed ID
     */
    val feedId: Int? = null,

    /**
     * The Feed URL
     */
    val feedURL: String? = null,

    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    val fulltext: Boolean? = null,
) {

    fun toParams(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["guid"] = guid
        map["feedid"] = feedId
        map["feedurl"] = feedURL
        map["fulltext"] = fulltext
        return map
    }
}
