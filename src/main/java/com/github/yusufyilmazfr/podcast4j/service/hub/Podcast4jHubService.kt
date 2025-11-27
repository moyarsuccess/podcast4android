package com.github.yusufyilmazfr.podcast4j.service.hub

interface Podcast4jHubService {
    /**
     * Notify the index that a feed has changed
     *
     * @param feedId The PodcastIndex Feed ID
     * @return true if API call is success otherwise false.
     */
    fun notifyByFeedId(feedId: Int): Boolean

    /**
     * Notify the index that a feed has changed
     *
     * @param feedURL The Podcast feed URL
     * @return true if API call is success otherwise false.
     */
    fun notifyByFeedURL(feedURL: String): Boolean
}
