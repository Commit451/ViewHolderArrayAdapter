package com.commit451.viewholderarrayadapter.sample

import android.content.Context
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter

/**
 * Example usage of [ViewHolderArrayAdapter]
 */
class CheeseSpinnerAdapter(
    context: Context,
    objects: List<Cheese>
) : ViewHolderArrayAdapter<Cheese, CheeseViewHolder, CheeseDropDownViewHolder>(
    context = context, objects = objects,
    onCreateViewHolder = { parent ->
        CheeseViewHolder.inflate(parent)
    },
    onCreateDropDownViewHolder = { parent ->
        CheeseDropDownViewHolder.inflate(parent)
    },
    onBindViewHolder = { viewHolder, _, item ->
        viewHolder.bind(item)
    },
    onBindDropDownViewHolder = { viewHolder, _, item ->
        viewHolder.bind(item)
    }
)
