package com.github.yusufyilmazfr.podcast4j.entity

data class AppleReplacementSearch(
    /**
     * The channel-level author element.
     * Usually iTunes specific, but could be from another namespace if not present.
     */
    val artistName: String? = null,

    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    val artworkUrl30: String? = null,

    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    val artworkUrl60: String? = null,

    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    val artworkUrl100: String? = null,

    /**
     * The name of the feed.
     * Note: Apple censors the name but PodcastIndex does not.
     */
    val collectionCensoredName: String? = null,

    /**
     * A URL for the artwork associated with the returned media type.
     * Note: Apple returns the image sized to value in the field name but the PodcastIndex returns the original image specified in the feed.
     */
    val artworkUrl600: String? = null,

    /**
     * Allowed: explicit┃cleaned
     * Indicates if the feed is marked explicit.
     */
    val collectionExplicitness: String? = null,

    /**
     * Price of content. Will always return 0.
     */
    val collectionHdPrice: Int? = null,

    /**
     * The iTunes Feed ID
     */
    val collectionId: Float = 0f,

    /**
     * Name of the feed
     */
    val collectionName: String? = null,

    /**
     * Price of content. Will always return 0.
     */
    val collectionPrice: Float = 0f,

    /**
     * The URL for viewing the feed on the Apple website.
     */
    val collectionViewUrl: String? = null,

    /**
     * Allowed: Clean┃Explicit
     * Indicates if the feed is explicit or clean.
     */
    val contentAdvisoryRating: String? = null,

    /**
     * The country the feed is from.
     * Note: Right now, always returns "USA"
     */
    val country: String? = null,

    /**
     * Currency *Price value is in.
     * Note: will always return "USD"
     */
    val currency: String? = null,

    /**
     * Current feed URL
     */
    val feedUrl: String? = null,

    /**
     * List of ids representing the names in the genres.
     * Values are determined by the IDs used in the url of genres on [genres](https://podcasts.apple.com/us/genre/podcasts/id26)
     */
    var genreIds: MutableList<Int?>? = null,

    /**
     * List of genre names.
     */
    var genres: MutableList<String?>? = null,

    /**
     * The kind of content returned by the search request.
     * Note: will always return "podcast"
     */

    val kind: String? = null,

    /**
     * The primary genre name.
     */
    val primaryGenreName: String? = null,

    /**
     * Date and time of request
     */
    val releaseDate: String? = null,

    /**
     * The name of the feed.
     * Note: Apple censors the name but PodcastIndex does not.
     */
    val trackCensoredName: String? = null,

    /**
     * Number of episodes in feed
     */
    val trackCount: Int? = null,

    /**
     * Allowed: explicit┃cleaned
     */
    val trackExplicitness: String? = null,

    /**
     * Price of content. Will always return 0.
     */
    val trackHdPrice: Int? = null,

    /**
     * Price of content. Will always return 0.
     */
    val trackHdRentalPrice: Int? = null,

    /**
     * The iTunes Feed ID
     */
    val trackId: Long? = null,

    /**
     * Name of the feed
     */
    val trackName: String? = null,

    /**
     * Price of content. Will always return 0.
     */
    val trackPrice: Int? = null,

    /**
     * Price of content. Will always return 0.
     */
    val trackRentalPrice: Int? = null,

    /**
     * The URL for viewing the feed on the Apple website.
     */
    val trackViewUrl: String? = null,

    /**
     * The name of the object returned by the search request.
     * Note: will always return "track"
     */
    val wrapperType: String? = null,
)
