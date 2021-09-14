package com.amaro.libraries.core.presentation

interface AdapterModel {
    fun layoutId(): Int
    fun isFilterable(filter: String): Boolean
}