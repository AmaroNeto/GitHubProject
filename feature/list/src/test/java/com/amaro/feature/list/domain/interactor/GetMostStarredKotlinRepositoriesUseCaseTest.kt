package com.amaro.feature.list.domain.interactor

import android.graphics.Movie
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.domain.repository.GitHubRepository
import com.amaro.libraries.core.domain.model.Output
import com.amaro.libraries.core.plugin.extensions.assert
import io.reactivex.rxjava3.core.Flowable
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetMostStarredKotlinRepositoriesUseCaseTest {
    @Mock
    private lateinit var repository: GitHubRepository
    private lateinit var useCase: GetMostStarredKotlinRepositoriesUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetMostStarredKotlinRepositoriesUseCase(repository)
    }

    @Test
    fun `when GetMostStarredKotlinRepositoriesUseCase is invoked then should result list of items`() {
        val result = listOf<Item>()
        Mockito.`when`(repository.getMostStartedKotlinRepositories()).thenReturn(Flowable.just(result))

        useCase.assert(null) {
            assertEquals(result, (it as Output.Success).data)
        }
        Mockito.verify(repository, Mockito.times(1)).getMostStartedKotlinRepositories()
    }

    @Test
    fun `when GetMostStarredKotlinRepositoriesUseCase receive a exception then return a fail`() {
        Mockito.`when`(repository.getMostStartedKotlinRepositories()).thenReturn(Flowable.error(Exception("Mock Error")))

        useCase.assert(null) {
            assertTrue(it is Output.Fail)
        }
        Mockito.verify(repository, Mockito.times(1)).getMostStartedKotlinRepositories()
    }
}