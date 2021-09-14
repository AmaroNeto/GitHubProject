package com.amaro.libraries.networking.plugin.api

import com.amaro.libraries.networking.domain.model.ItemResult
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubAPI {
    @GET("search/repositories")
    fun getGitHubRepositories(@Query("q") language: String, @Query("sort") sort: String, @Query("page") page: String): Flowable<ItemResult>
}