package com.github.yusufyilmazfr.podcast4j.arg.service.episode

data class ByFeedIdArg(
    /**
     * (Required) The PodcastIndex Feed ID or IDs to search for.
     * If searching for multiple IDs, separate values with a comma. A maximum of 200 IDs can be provided.
     */
    val id: Int? = null,

    /**
     * Maximum number of results to return.
     */
    val max: Int? = null,

    /**
     * Return items since the specified time.
     * The value can be a unix epoch timestamp or a negative integer that represents a number of seconds prior to right now.
     */
    val since: Long? = null,

    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    val fulltext: Boolean? = null,
) {
    fun toParams(): Map<String, Any?> {
        val map: MutableMap<String, Any?> = HashMap()
        map["id"] = id
        map["max"] = max
        map["since"] = since
        map["fulltext"] = fulltext
        return map
    }
}
