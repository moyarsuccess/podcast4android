package com.github.yusufyilmazfr.podcast4j.util

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.github.yusufyilmazfr.podcast4j.entity.Podcast

class PodcastDeserializer : JsonDeserializer<Podcast?>() {
    override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext?): Podcast? {
        val node = jsonParser.codec.readTree<JsonNode>(jsonParser)

        // handle empty array when no feed
        if (node.isArray && node.isEmpty) {
            return null
        }
        return jsonParser.codec.treeToValue(node, Podcast::class.java)
    }
}
