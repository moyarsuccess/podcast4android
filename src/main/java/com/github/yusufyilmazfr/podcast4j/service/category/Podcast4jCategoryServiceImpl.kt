package com.github.yusufyilmazfr.podcast4j.service.category;

import com.github.yusufyilmazfr.podcast4j.constant.Constant.BASE_API_V1_URL
import com.github.yusufyilmazfr.podcast4j.entity.Category
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.config
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.gson
import com.github.yusufyilmazfr.podcast4j.factory.Podcast4jServiceFactory.okHttpClient
import com.github.yusufyilmazfr.podcast4j.response.CategoriesResponse
import com.github.yusufyilmazfr.podcast4j.util.HttpRequestUtil

internal object Podcast4jCategoryServiceImpl : Podcast4jCategoryService {

    override fun all(): List<Category> {
        val request = HttpRequestUtil.with(config)
            .url("$BASE_API_V1_URL/categories/list")
            .build()
        try {
            val response = okHttpClient.newCall(request).execute()
            if (!response.isSuccessful) return emptyList()
            return gson.fromJson(response.body?.string(), CategoriesResponse::class.java).categories
        } catch (_: Exception) {
            return emptyList()
        }
    }
}
