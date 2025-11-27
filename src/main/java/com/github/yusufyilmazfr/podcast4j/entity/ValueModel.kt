package com.github.yusufyilmazfr.podcast4j.entity

/**
 * Description of the method for providing "Value for Value" payments
 */
data class ValueModel(
    /**
     * Payment type, allowed:
     *
     *  * lightning
     *  * hive
     *  * webmonetization
     *
     */
    val type: String? = null,

    /**
     * Method for sending payment
     */
    val method: String? = null,

    /**
     * Suggested amount per second of playback to send. Unit is specific to the type.
     */
    val suggested: String? = null,
)
