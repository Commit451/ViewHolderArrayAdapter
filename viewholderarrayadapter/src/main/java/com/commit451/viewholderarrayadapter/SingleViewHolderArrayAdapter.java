package com.commit451.viewholderarrayadapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * {@link ViewHolderArrayAdapter} that uses the same
 * {@link android.support.v7.widget.RecyclerView.ViewHolder} for both the dropdown and the selected view
 */
public abstract class SingleViewHolderArrayAdapter<T, VH extends RecyclerView.ViewHolder> extends ViewHolderArrayAdapter<T, VH, VH> {

    /**
     * Create the single shared view holder
     * @param parent parent
     * @return the created view holder
     */
    protected abstract VH onCreateSingleViewHolder(@NonNull ViewGroup parent);

    /**
     * Bind the item
     * @param holder holder
     * @param t item
     * @param position position
     */
    protected abstract void onBindSingleViewHolder(@NonNull VH holder, T t, int position);

    public SingleViewHolderArrayAdapter(Context context, List<T> objects) {
        super(context, objects);
    }

    @CallSuper
    @NonNull
    @Override
    protected VH onCreateViewHolder(@NonNull ViewGroup parent) {
        return onCreateSingleViewHolder(parent);
    }

    @CallSuper
    @NonNull
    @Override
    protected VH onCreateDropDownViewHolder(@NonNull ViewGroup parent) {
        return onCreateSingleViewHolder(parent);
    }

    @CallSuper
    @Override
    protected void onBindViewHolder(@NonNull VH holder, T item, int position) {
        onBindSingleViewHolder(holder, item, position);
    }

    @CallSuper
    @Override
    protected void onBindDropDownViewHolder(@NonNull VH holder, T item, int position) {
        onBindSingleViewHolder(holder, item, position);
    }
}
