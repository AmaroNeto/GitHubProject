package com.amaro.libraries.networking.plugin

import com.amaro.libraries.networking.plugin.api.GitHubAPI

interface RetrofitConfig {
    fun getGitHubAPI(): GitHubAPI
}