package com.commit451.viewholderarrayadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * [ViewHolderArrayAdapter] that uses the same
 * [android.support.v7.widget.RecyclerView.ViewHolder] for both the dropdown and the selected view
 */
open class SingleViewHolderArrayAdapter<T, VH : RecyclerView.ViewHolder>(context: Context, objects: List<T>,
                                                                             onCreateViewHolder: (parent: ViewGroup) -> VH,
                                                                             onBindViewHolder: (viewHolder: VH, position: Int, item: T) -> Unit) : ViewHolderArrayAdapter<T, VH, VH>(context, objects, onCreateViewHolder, onCreateViewHolder, onBindViewHolder, onBindViewHolder)
