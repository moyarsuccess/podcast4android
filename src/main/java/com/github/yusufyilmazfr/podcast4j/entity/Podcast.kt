package com.github.yusufyilmazfr.podcast4j.entity

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import java.lang.reflect.Type

data class Podcast(
    /**
     * The internal PodcastIndex.org Feed ID.
     */
    val id: Int? = null,

    /**
     * The GUID from the podcast:guid tag in the feed. This value is a unique, global identifier for the podcast.
     * See the namespace spec for [guid](https://github.com/Podcastindex-org/podcast-namespace/blob/main/docs/1.0.md#guid) for details.
     */
    val podcastGuid: String? = null,

    /**
     * Name of the feed
     */
    val title: String? = null,

    /**
     * Current feed URL
     */
    val url: String? = null,

    /**
     * The URL of the feed, before it changed to the current url value.
     */
    val originalUrl: String? = null,

    /**
     * The channel-level link in the feed
     */
    val link: String? = null,

    /**
     * The channel-level description
     * Uses the longest of the possible fields in the feed: <description>, <itunes:summary> and <content:encoded>
    </content:encoded></itunes:summary></description> */
    val description: String? = null,

    /**
     * The channel-level author element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    val author: String? = null,

    /**
     * The channel-level owner:name element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    val ownerName: String? = null,

    /**
     * The channel-level image element.
     */
    val image: String? = null,

    /**
     * Seemingly the best artwork we can find for the feed. Might be the same as image in most instances.
     */
    val artwork: String? = null,

    /**
     * The channel-level pubDate for the feed, if it’s sane.
     * If not, this is a heuristic value, arrived at by analyzing other parts of the feed, like item-level pubDates.
     */
    val lastUpdateTime: Long? = null,

    /**
     * The last time we attempted to pull this feed from its url.
     */
    val lastCrawlTime: Long? = null,

    /**
     * The last time we tried to parse the downloaded feed content.
     */
    val lastParseTime: Long? = null,

    /**
     * Timestamp of the last time we got a "good", meaning non-4xx/non-5xx, status code when pulling this feed from its url.
     */
    val lastGoodHttpStatusTime: Long? = null,

    /**
     * The last http status code we got when pulling this feed from its url.
     * You will see some made up status codes sometimes. These are what we use to track state within the feed puller. These all start with 9xx.
     */
    val lastHttpStatus: Int? = null,

    /**
     * The Content-Type header from the last time we pulled this feed from its url.
     */
    val contentType: String? = null,

    /**
     * The iTunes ID of this feed if there is one, and we know what it is.
     */
    val itunesId: Long? = null,

    /**
     * The type as specified by the itunes:type in the feed XML.
     */
    val itunesType: String? = null,

    /**
     * The channel-level generator element if there is one.
     */
    val generator: String? = null,

    /**
     * The channel-level language specification of the feed. Languages accord with the RSS Language Spec.
     */
    val language: String? = null,

    /**
     * Is feed marked as explicit
     */
    @JsonAdapter(ExplicitAdapter::class)
    val explicit: Int? = null,

    /**
     * Allowed: 0┃1
     * Type of source feed where: 0: RSS, 1: Atom
     */
    val type: Int? = null,

    /**
     * At some point, we give up trying to process a feed and mark it as dead.
     * This is usually after 1000 errors without a successful pull/parse cycle.
     * Once the feed is marked dead, we only check it once per month.
     */
    val dead: Int? = null,

    /**
     * The md5 hash of the following feed items in hex format.
     *
     *  * title
     *  * link
     *  * feedLanguage
     *  * generator
     *  * author
     *  * ownerName
     *  * ownerEmail (note: not exposed via the API)
     *
     * Pseudo-code:
     *
     *
     * `chash = md5(title+link+feedLanguage+generator+author+ownerName+ownerEmail)`
     */
    val chash: String? = null,

    /**
     * Number of episodes for this feed known to the index.
     */
    val episodeCount: Int? = null,

    /**
     * The number of errors we’ve encountered trying to pull a copy of the feed. Errors are things like a 500 or 404 response, a server timeout, bad encoding, etc.
     */
    val crawlErrors: Int? = null,

    /**
     * The number of errors we’ve encountered trying to parse the feed content. Errors here are things like not well-formed xml, bad character encoding, etc.
     * We fix many of these types of issues on the fly when parsing. We only increment the errors count when we can’t fix it.
     */
    val parseErrors: Int? = null,

    /**
     * Allowed: 0┃1
     * Tell other podcast platforms whether they are allowed to import this feed. A value of 1 means that any attempt to import this feed into a new platform should be rejected. Contains the value of the feed's channel-level podcast:locked tag where:
     *
     *  * 0: 'no'
     *  * 1: 'yes'
     *
     */
    val locked: Int? = null,

    /**
     * A CRC32 hash of the image URL with the protocol (http://, https://) removed.
     */
    val imageUrlHash: Long? = null,
    val valueCreatedOn: Long? = null,
    val newestItemPubdate: Long? = null,

    /**
     * An array of categories, where the index is the Category ID and the value is the Category Name.
     */
    val categories: MutableMap<Int?, String?>? = null,

    /**
     * Information for donation/funding the podcast.
     */
    val funding: Funding? = null,

    /**
     * Information for supporting the podcast via one of the "Value for Value" methods.
     */
    val value: Value? = null,

    val medium: String? = null,

    val inPollingQueue: String? = null,

    val priority: String? = null,
)

class ExplicitAdapter : JsonDeserializer<Int> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Int {
        val primitive = json.asJsonPrimitive

        return when {
            primitive.isNumber -> primitive.asInt
            primitive.isBoolean -> if (primitive.asBoolean) 1 else 0
            primitive.isString -> primitive.asString.toIntOrNull() ?: 0
            else -> 0
        }
    }
}
