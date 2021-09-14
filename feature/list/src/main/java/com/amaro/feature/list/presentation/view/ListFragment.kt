package com.amaro.feature.list.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaro.feature.list.databinding.ListFragmentBinding
import com.amaro.feature.list.domain.model.Item
import com.amaro.feature.list.gateway.ListViewModel
import com.amaro.feature.list.presentation.adapter.ItemAdapter
import com.amaro.libraries.core.plugin.extensions.hide
import com.amaro.libraries.core.plugin.extensions.onObserver
import com.amaro.libraries.core.plugin.extensions.show
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment: Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ListFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        onObserver(viewModel.itemList) {
            setListData(it)
        }
        onObserver(viewModel.loading) {
            setUpLoading(it)
        }
    }

    private fun setupViews() {
        binding.recyclerView.apply {
            layoutManager =  LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
        }
    }

    private fun setUpLoading(value: Boolean) {
        if (value) {
            binding.progressCircular.run {
                visibility = View.VISIBLE
            }
            binding.recyclerView.hide()
        } else {
            binding.progressCircular.hide()
            binding.recyclerView.show()
        }
    }

    private fun setListData(items: List<Item>) {
        val adapter = ItemAdapter(items)
        binding.recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadGitHubRepositories()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}