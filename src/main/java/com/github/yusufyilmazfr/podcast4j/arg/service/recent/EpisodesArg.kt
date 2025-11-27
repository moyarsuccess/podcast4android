package com.github.yusufyilmazfr.podcast4j.arg.service.recent

data class EpisodesArg(
    /**
     * Maximum number of results to return.
     */
    val max: Int? = null,

    /**
     * If you pass a PodcastIndex Episode ID, you will get recent episodes before that ID,
     * allowing you to walk back through the episode history sequentially.
     */
    val before: Long? = null,

    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    val fullText: Boolean? = null,

    /**
     * Any item containing this string will be discarded from the result set.
     * This may, in certain cases, reduce your set size below your `max` value.
     * Matches against the `title` and URL properties.
     */
    val excludeString: String? = null,
) {


    fun toParams(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["max"] = max
        map["before"] = before
        map["fulltext"] = fullText
        map["excludeString"] = excludeString
        return map
    }
}
