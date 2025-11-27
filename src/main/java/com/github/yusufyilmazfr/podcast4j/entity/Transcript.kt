package com.github.yusufyilmazfr.podcast4j.entity

import java.net.URL

data class Transcript(
    /**
     * URL of the podcast transcript.
     */
    val url: URL? = null,

    /**
     * Allowed:
     *
     *  * application/json
     *  * application/srt
     *  * text/html
     *  * text/plain
     *  * text/srt
     *  * text/vtt
     *
     */
    var type: String? = null,
)