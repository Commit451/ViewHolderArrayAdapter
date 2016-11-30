package com.commit451.viewholderarrayadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Easy easy easy Text view view holder
 */
class TextViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    TextViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(android.R.id.text1);
    }

    public void bind(Object object) {
        text.setText(object.toString());
    }
}
