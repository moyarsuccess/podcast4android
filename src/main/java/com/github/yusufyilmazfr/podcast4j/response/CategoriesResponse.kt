package com.github.yusufyilmazfr.podcast4j.response

import com.github.yusufyilmazfr.podcast4j.entity.Category
import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("feeds")
    var categories: MutableList<Category>
) : BaseResponse()
