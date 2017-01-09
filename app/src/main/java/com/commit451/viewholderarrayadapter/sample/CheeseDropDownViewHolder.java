package com.commit451.viewholderarrayadapter.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The view holder related to each Cheese item
 */
public class CheeseDropDownViewHolder extends RecyclerView.ViewHolder {

    public static CheeseDropDownViewHolder inflate(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spinner_dropdown_cheese, parent, false);
        return new CheeseDropDownViewHolder(view);
    }

    public TextView title;
    public ImageView image;

    public CheeseDropDownViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(android.R.id.text1);
        image = (ImageView) view.findViewById(R.id.image);
    }

    public void bind(Cheese cheese) {
        title.setText(cheese.getName());
        image.setImageResource(cheese.getDrawable());
    }
}
