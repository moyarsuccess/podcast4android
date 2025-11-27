package com.github.yusufyilmazfr.podcast4j.util

import com.github.yusufyilmazfr.podcast4j.config.Config
import okhttp3.Request
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.Instant

internal object HttpRequestUtil {

    @JvmStatic
    fun with(config: Config): Request.Builder {
        val epochSeconds = Instant
            .now()
            .epochSecond

        val data4Hash = config.authKey + config.secret + epochSeconds
        val hashString = SecurityUtil.toSHA1(data4Hash)

        return Request.Builder()
            .header("X-Auth-Date", epochSeconds.toString())
            .header("X-Auth-Key", config.authKey ?: "")
            .header("Authorization", hashString)
            .header("User-Agent", config.getUserAgent())
    }

    fun toQueryParams(data: Map<String, Any?>): String {
        val builder = StringBuilder()
        for (entry in data.entries) {
            if (builder.isNotEmpty()) {
                builder.append("&")
            }
            builder.append(URLEncoder.encode(entry.key, StandardCharsets.UTF_8))
            builder.append("=")
            builder.append(URLEncoder.encode(entry.value.toString(), StandardCharsets.UTF_8))
        }

        return builder.toString()
    }
}
