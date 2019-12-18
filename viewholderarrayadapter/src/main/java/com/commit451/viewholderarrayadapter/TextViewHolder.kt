package com.commit451.viewholderarrayadapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Easy easy easy Text view view holder holder
 */
class TextViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var text: TextView? = itemView.findViewById(android.R.id.text1)

    fun bind(`object`: T) {
        text?.text = `object`.toString()
    }
}
