package com.commit451.viewholderarrayadapter.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * The view holder related to each Cheese item
 */
class CheeseDropDownViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun inflate(parent: ViewGroup): CheeseDropDownViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_spinner_dropdown_cheese, parent, false)
            return CheeseDropDownViewHolder(view)
        }
    }

    var title: TextView = view.findViewById(android.R.id.text1)
    var image: ImageView = view.findViewById(R.id.image)

    fun bind(cheese: Cheese) {
        title.text = cheese.name
        image.setImageResource(cheese.drawable)
    }
}
