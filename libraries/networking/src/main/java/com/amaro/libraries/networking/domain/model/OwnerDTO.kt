package com.amaro.libraries.networking.domain.model

import com.google.gson.annotations.SerializedName

data class OwnerDTO(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String
)