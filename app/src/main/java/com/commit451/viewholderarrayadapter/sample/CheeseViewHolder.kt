package com.commit451.viewholderarrayadapter.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * The view holder related to each Cheese item
 */
class CheeseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {

        fun inflate(parent: ViewGroup): CheeseViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_spinner_cheese, parent, false)
            return CheeseViewHolder(view)
        }
    }

    var title: TextView = view.findViewById(android.R.id.text1)
    var image: ImageView = view.findViewById(R.id.image)

    fun bind(cheese: Cheese) {
        title.text = cheese.name
        image.setImageResource(cheese.drawable)
    }
}
