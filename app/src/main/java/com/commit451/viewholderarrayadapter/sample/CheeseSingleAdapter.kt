package com.commit451.viewholderarrayadapter.sample

import android.content.Context
import com.commit451.viewholderarrayadapter.SingleViewHolderArrayAdapter
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter

/**
 * Example usage of [ViewHolderArrayAdapter]
 */
class CheeseSingleAdapter(
    context: Context,
    objects: List<Cheese>
) : SingleViewHolderArrayAdapter<Cheese, CheeseViewHolder>(
    context = context,
    objects = objects,
    onCreateViewHolder = { parent ->
        CheeseViewHolder.inflate(parent)
    },
    onBindViewHolder = { viewHolder, _, item ->
        viewHolder.bind(item)
    }
)
