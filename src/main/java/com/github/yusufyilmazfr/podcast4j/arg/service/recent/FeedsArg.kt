package com.github.yusufyilmazfr.podcast4j.arg.service.recent

data class FeedsArg(
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
     * Specifying a language code (like "en") will return only episodes having that specific language.
     * You can specify multiple languages by separating them with commas.
     * If you also want to return episodes that have no language given, use the token "unknown". (ex. en,es,ja,unknown).
     * Values are not case-sensitive.
     */
    val lang: String? = null,

    /**
     * Use this argument to specify that you **ONLY** want episodes with these categories in the results.
     * Separate multiple categories with commas.
     * You may specify either the Category ID and/or the Category Name.
     * Values are not case-sensitive.
     * The `cat` and `notcat` filters can be used together to fine tune a very specific result set.
     * Category numbers and names can be found in the [Podcast Namespace documentation]([categories](https://github.com/Podcastindex-org/podcast-namespace/blob/main/categories.json))
     */
    val cat: String? = null,

    /**
     * Use this argument to specify categories of episodes to **NOT** show in the results.
     * Separate multiple categories with commas.
     * You may specify either the Category ID and/or the Category Name.
     * Values are not case-sensitive.
     * The `cat` and `notcat` filters can be used together to fine tune a very specific result set.
     * Category numbers and names can be found in the [Podcast Namespace documentation]([categories](https://github.com/Podcastindex-org/podcast-namespace/blob/main/categories.json))
     */
    val notCat: String? = null,
) {

    fun toParams(): MutableMap<String, Any?> {
        val map = HashMap<String, Any?>()
        map["max"] = max
        map["since"] = since
        map["lang"] = lang
        map["cat"] = cat
        map["notcat"] = notCat
        return map
    }
}
