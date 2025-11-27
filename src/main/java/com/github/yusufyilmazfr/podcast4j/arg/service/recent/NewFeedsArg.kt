package com.github.yusufyilmazfr.podcast4j.arg.service.recent

data class NewFeedsArg(
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
     * The PodcastIndex Feed ID to start from (or go to if `desc` specified).
     * If `since` parameter also specified, value of `since` is ignored.
     */
    val feedId: Int? = null,

    /**
     * If present, display feeds in descending order.
     * Only applicable when using `feedid` parameter.
     * Parameter shall not have a value
     */
    val desc: Boolean? = null,
) {

    fun toParams(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["max"] = max
        map["since"] = since
        map["feedid"] = feedId
        map["desc"] = desc

        return map
    }
}
