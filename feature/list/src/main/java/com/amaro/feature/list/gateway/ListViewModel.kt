package com.amaro.feature.list.gateway

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amaro.feature.list.domain.interactor.GetMostStarredKotlinRepositoriesUseCase
import com.amaro.feature.list.domain.model.Item
import com.amaro.libraries.core.domain.model.Output

class ListViewModel(
    private val getGetMostStarredKotlinRepositoriesUseCase: GetMostStarredKotlinRepositoriesUseCase
): ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList = _itemList
    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    fun loadGitHubRepositories() {
        _loading.postValue(true)
        getGetMostStarredKotlinRepositoriesUseCase(null) {
            handlePopularMoviesResult(it)
            _loading.postValue(false)
        }
    }

    private fun handlePopularMoviesResult(output: Output<List<Item>>) {
        if (output is Output.Success<List<Item>>) {
            _itemList.postValue(output.data!!)
        } else {
            // TODO
        }
    }
}