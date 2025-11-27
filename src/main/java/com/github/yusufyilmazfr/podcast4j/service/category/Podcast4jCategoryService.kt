package com.github.yusufyilmazfr.podcast4j.service.category

import com.github.yusufyilmazfr.podcast4j.entity.Category

interface Podcast4jCategoryService {
    fun all(): List<Category>
}
