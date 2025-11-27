package com.github.yusufyilmazfr.podcast4j.entity

/**
 * Destination where "Value for Value" payments should be sent.
 */
data class ValueDestination(
    /**
     * Name for the destination
     */
    val name: String? = null,

    /**
     * Address of node to receive payment
     */
    val address: String? = null,

    /**
     * Allowed: node
     * Type of destination
     */
    val type: String? = null,

    /**
     * Share of payment the destination should receive
     */
    val split: Int? = null,

    /**
     * Indicates if destination is included due to a fee being charged
     */
    val fee: Boolean? = null,

    /**
     * The name of a custom record key to send along with the payment.
     */
    val customKey: String? = null,

    /**
     * A custom value to pass along with the payment. This is considered the value that belongs to the customKey.
     */
    val customValue: String? = null,
)
