package com.github.yusufyilmazfr.podcast4j.util

import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object SecurityUtil {
    fun toSHA1(text: String): String {
        var digest: MessageDigest? = null
        try {
            digest = MessageDigest.getInstance("SHA-1")
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
        digest.reset()
        digest.update(text.toByteArray(StandardCharsets.UTF_8))
        return String.format("%040x", BigInteger(1, digest.digest()))
    }
}
