package com.commit451.viewholderarrayadapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * [ViewHolderArrayAdapter] that uses the same
 * [RecyclerView.ViewHolder] for both the dropdown and the selected view
 */
open class SingleViewHolderArrayAdapter<T, VH : RecyclerView.ViewHolder>(
    context: Context, objects: List<T>,
    onCreateViewHolder: (parent: ViewGroup) -> VH,
    onBindViewHolder: (viewHolder: VH, position: Int, item: T) -> Unit
) : ViewHolderArrayAdapter<T, VH, VH>(context, objects, onCreateViewHolder, onCreateViewHolder, onBindViewHolder, onBindViewHolder)
