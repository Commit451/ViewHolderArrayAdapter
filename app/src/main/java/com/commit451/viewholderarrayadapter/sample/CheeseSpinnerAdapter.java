package com.commit451.viewholderarrayadapter.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter;

import java.util.List;

/**
 * Example usage of {@link ViewHolderArrayAdapter}
 */
public class CheeseSpinnerAdapter extends ViewHolderArrayAdapter<Cheese, CheeseViewHolder, CheeseDropDownViewHolder> {

    public CheeseSpinnerAdapter(Context context, List<Cheese> objects) {
        super(context, objects);
    }

    @NonNull
    @Override
    protected CheeseViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @NonNull
    @Override
    protected CheeseDropDownViewHolder onCreateDropDownViewHolder(@NonNull ViewGroup parent) {
        return CheeseDropDownViewHolder.inflate(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }

    @Override
    protected void onBindDropDownViewHolder(@NonNull CheeseDropDownViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
