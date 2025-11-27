package com.github.yusufyilmazfr.podcast4j.arg.service.episode

data class ByIdArg(
    /**
     * (Required) The PodcastIndex episode ID to search for.
     */
    val id: Long? = null,

    /**
     * If present, return the full text value of any text fields (ex: `description`).
     * If not provided, field value is truncated to 100 words.
     * Parameter shall not have a value
     */
    val fulltext: Boolean? = null,
) {

    fun toParams(): Map<String, Any?> {
        val map = HashMap<String, Any?>()
        map["id"] = id
        map["fulltext"] = fulltext
        return map
    }
}
