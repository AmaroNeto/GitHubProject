package com.amaro.feature.list.plugin.repository

import android.graphics.Movie
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.repository.GitHubRepository
import com.amaro.feature.list.plugin.nonOptionalAny
import com.amaro.libraries.core.domain.mapper.ListMapper
import com.amaro.libraries.core.domain.mapper.NullableInputListMapper
import com.amaro.libraries.networking.domain.model.ItemDTO
import com.amaro.libraries.networking.domain.model.ItemResult
import com.amaro.libraries.networking.plugin.RetrofitConfig
import com.amaro.libraries.networking.plugin.api.GitHubAPI
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock

class GitHubRepositoryTest {
    @Mock
    private lateinit var retrofitConfig: RetrofitConfig

    @Mock
    private lateinit var gitHubAPI: GitHubAPI

    @Mock
    private lateinit var mapper: ListMapper<ItemDTO, Item>

    private lateinit var repository: GitHubRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = GitHubRepositoryImpl(
            retrofitConfig,
            mapper
        )
    }

    @Test
    fun `when fetchGitHubRepositories then should return Items`() {
        val result: ItemResult = mock()
        val item: Item = mock()

        Mockito.`when`(retrofitConfig.getGitHubAPI()).thenReturn(gitHubAPI)
        Mockito.`when`(gitHubAPI.getGitHubRepositories(nonOptionalAny(), nonOptionalAny(), nonOptionalAny())).thenReturn(
            Flowable.just(result))
        Mockito.`when`(mapper.map(nonOptionalAny())).thenReturn(listOf(item))

        repository.getMostStartedKotlinRepositories().test().assertValue(listOf(item))
    }
}