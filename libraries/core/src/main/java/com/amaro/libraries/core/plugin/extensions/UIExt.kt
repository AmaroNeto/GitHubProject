package com.amaro.libraries.core.plugin.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T> Fragment.onObserver(eventSource: LiveData<T>, handler: (T) -> Unit) {
    eventSource.observe(viewLifecycleOwner, { handler(it) } )
}