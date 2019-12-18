package com.commit451.viewholderarrayadapter

import android.content.Context
import androidx.annotation.LayoutRes

/**
 * Simple implementation which calls the [Object.toString] on whatever object is passed. Similar
 * to a normal [android.widget.ArrayAdapter] you would use with a spinner, it expects that the custom
 * ViewHolder layout you provide at least contains a TextView with an id of android.R.id.text1
 */
class TextViewHolderArrayAdapter<T>

/**
 * Construct an adapter with your provided data and custom layout resource
 * @param context context
 * @param layoutRes the custom layout resource. Make sure you have a [android.widget.TextView] with an id of android.R.id.text1
 * @param dropdownLayoutRes the custom layout resource. Make sure you have a [android.widget.TextView] with an id of android.R.id.text1
 * @param objects the items, which will get their title via [Object.toString]
 */
(context: Context, @LayoutRes private val layoutRes: Int, @LayoutRes private val dropdownLayoutRes: Int, objects: List<T>) : ViewHolderArrayAdapter<T, TextViewHolder<T>, TextViewHolder<T>>(context, objects, { parent ->
    Util.createHolder(parent, layoutRes) as TextViewHolder<T>
}, { parent ->
    Util.createHolder(parent, dropdownLayoutRes) as TextViewHolder<T>
}, { viewHolder, _, item ->
    viewHolder.bind(item)
}, { viewHolder, _, item ->
    viewHolder.bind(item)
})
