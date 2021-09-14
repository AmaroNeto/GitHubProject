package com.amaro.libraries.core.plugin.extensions

import android.view.View

fun View.hide(invisible: Boolean = false) {
    this.visibility = if (invisible) View.INVISIBLE else View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}