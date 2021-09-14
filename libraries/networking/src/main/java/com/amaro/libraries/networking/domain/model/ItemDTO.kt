package com.amaro.libraries.networking.domain.model

import com.google.gson.annotations.SerializedName

data class ItemDTO(
    val id: Int,
    val name: String,
    val owner: OwnerDTO,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("stargazers_count") val starCount: Int,
    @SerializedName("forks_count") val forksCount: Int
)