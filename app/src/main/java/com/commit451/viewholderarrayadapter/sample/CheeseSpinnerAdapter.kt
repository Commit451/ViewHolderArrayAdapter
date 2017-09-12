package com.commit451.viewholderarrayadapter.sample

import android.content.Context
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter

/**
 * Example usage of [ViewHolderArrayAdapter]
 */
class CheeseSpinnerAdapter(context: Context, objects: List<Cheese>) : ViewHolderArrayAdapter<Cheese, CheeseViewHolder, CheeseDropDownViewHolder>(context, objects, { parent ->
 CheeseViewHolder.inflate(parent)
}, { parent ->
    CheeseDropDownViewHolder.inflate(parent)
}, { viewHolder, _, item ->
    viewHolder.bind(item)
}, { viewHolder, _, item ->
    viewHolder.bind(item)
})
