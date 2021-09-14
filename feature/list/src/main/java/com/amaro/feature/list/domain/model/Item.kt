package com.amaro.feature.list.domain.model

data class Item (
    val id: Int,
    val name: String,
    val owner: Owner,
    val fullName: String,
    val starCount: Int,
    val forksCount: Int
)