package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

/**
 * People with an interest in episode.
 */
data class Person(
    /**
     * The internal PodcastIndex.org person ID.
     */
    val id: Int? = null,

    /**
     * The name of the person.
     */
    val name: String? = null,

    /**
     * Used to identify what role the person serves on the show or episode.
     */
    val role: String? = null,

    /**
     * The group the person's role is in.
     */
    val group: String? = null,

    /**
     * The url to a relevant resource of information about the person, such as a homepage or third-party profile platform.
     */
    val href: URL? = null,

    /**
     * URL to a picture or avatar of the person.
     */
    val img: URL? = null,
)
