package com.github.yusufyilmazfr.podcast4j.entity

data class Value(
    val model: ValueModel? = null,
    val destinations: MutableList<ValueDestination?>? = null,
)
