package com.commit451.viewholderarrayadapter.sample

import android.content.Context
import com.commit451.viewholderarrayadapter.SingleViewHolderArrayAdapter
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter

/**
 * Example usage of [ViewHolderArrayAdapter]
 */
class CheeseSingleAdapter(context: Context, objects: List<Cheese>) : SingleViewHolderArrayAdapter<Cheese, CheeseViewHolder>(context, objects, { parent ->
    CheeseViewHolder.inflate(parent)
}, {viewHolder, _, item ->
    viewHolder.bind(item)
})
