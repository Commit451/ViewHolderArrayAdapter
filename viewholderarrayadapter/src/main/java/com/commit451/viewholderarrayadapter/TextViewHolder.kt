package com.commit451.viewholderarrayadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Easy easy easy Text view view holder holder
 */
class TextViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var text: TextView? = itemView.findViewById(android.R.id.text1)

    fun bind(`object`: T) {
        text?.text = `object`.toString()
    }
}
