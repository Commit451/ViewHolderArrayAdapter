package com.commit451.viewholderarrayadapter.sample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.commit451.viewholderarrayadapter.SingleViewHolderArrayAdapter;
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter;

import java.util.List;

/**
 * Example usage of {@link ViewHolderArrayAdapter}
 */
public class CheeseSingleAdapter extends SingleViewHolderArrayAdapter<Cheese, CheeseViewHolder> {

    public CheeseSingleAdapter(Context context, List<Cheese> objects) {
        super(context, objects);
    }

    @NonNull
    @Override
    protected CheeseViewHolder onCreateSingleViewHolder(@NonNull ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @Override
    protected void onBindSingleViewHolder(@NonNull CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
