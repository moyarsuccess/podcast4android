package com.github.yusufyilmazfr.podcast4j.arg.service.search

data class SearchPodcastsByTermArg(
    /**
     * (Required) Terms to search for
     */
    val q: String? = null,

    /**
     * Only returns feeds with a value block of the specified type. Use any to return feeds with any value block.
     *
     *
     * Allowed:
     *
     *  * any
     *  * lightning
     *  * hive
     *  * webmonetization
     *
     */
    val `val`: String? = null,

    /**
     * Maximum number of results to return.
     *
     * Examples: 10
     */
    val max: Int? = null,

    /**
     * Only returns feeds with an itunesId.
     */
    val aponly: Boolean? = null,

    /**
     * If present, only non-explicit feeds will be returned. Meaning, feeds where the itunes:explicit flag is set to false.
     * Parameter shall not have a value
     */
    val clean: Boolean? = null,

    /**
     * If present, include similar matches in search response. For search/byterm, prioritizes title matches.
     */
    val similar: Boolean? = null,

    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    val fulltext: Boolean? = null,
) {

    fun toParams(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["q"] = q
        map["val"] = `val`
        map["max"] = max
        map["aponly"] = aponly
        map["clean"] = clean
        map["similar"] = similar
        map["fulltext"] = fulltext
        return map
    }
}
