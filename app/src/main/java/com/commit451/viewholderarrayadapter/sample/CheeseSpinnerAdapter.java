package com.commit451.viewholderarrayadapter.sample;

import android.content.Context;
import android.view.ViewGroup;

import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter;

import java.util.List;

/**
 * Example usage of {@link ViewHolderArrayAdapter}
 */
public class CheeseSpinnerAdapter extends ViewHolderArrayAdapter<Cheese, CheeseViewHolder> {

    public CheeseSpinnerAdapter(Context context, List<Cheese> objects) {
        super(context, objects);
    }

    @Override
    protected CheeseViewHolder onCreateViewHolder(ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @Override
    protected void onBindViewHolder(CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
