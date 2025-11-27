package com.github.yusufyilmazfr.podcast4j.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.yusufyilmazfr.podcast4j.constant.Constant
import java.net.ProxySelector

data class Config(
    val authKey: String? = null,
    val secret: String? = null,
    val userAgentValue: String? = null,
    val timeOutValue: Int = 0,
    val objectMapper: ObjectMapper? = null,
    val proxySelector: ProxySelector? = null,
) {

    fun getTimeOut(): Int {
        return if (timeOutValue == 0) Constant.DEFAULT_HTTP_TIMEOUT else timeOutValue
    }

    fun getUserAgent(): String {
        return userAgentValue ?: Constant.DEFAULT_USER_AGENT
    }
}
