package com.commit451.viewholderarrayadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

internal object Util {

    internal fun createHolder(parent: ViewGroup, @LayoutRes layoutRes: Int): TextViewHolder<Any> {
        if (layoutRes == -1) {
            throw IllegalStateException("You must provide a valid layout resource")
        }
        val view = LayoutInflater.from(parent.context)
                .inflate(layoutRes, parent, false)
        val holder = TextViewHolder<Any>(view)
        if (holder.text == null) {
            throw IllegalArgumentException("The layout you provide must have a TextView with a layout id of android.R.id.text1")
        }
        return holder
    }
}
