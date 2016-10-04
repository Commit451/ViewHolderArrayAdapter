package com.commit451.viewholderarrayadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Uses the magic of {@link android.support.v7.widget.RecyclerView.ViewHolder}s with
 * {@link ArrayAdapter} to make great Spinner adapters
 */
public abstract class ViewHolderArrayAdapter<T, H extends RecyclerView.ViewHolder> extends ArrayAdapter<T> {

    protected abstract H onCreateViewHolder(ViewGroup parent);
    protected abstract void onBindViewHolder(H holder, T item, int position);

    public ViewHolderArrayAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getTheView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getTheView(position, convertView, parent);
    }

    private View getTheView(int position, View convertView, ViewGroup parent) {
        T item = getItem(position);
        H holder;
        if (convertView == null) {
            holder = onCreateViewHolder(parent);
            holder.itemView.setTag(R.id.view_holder_array_adapter_id, holder);
        } else {
            holder = (H) convertView.getTag(R.id.view_holder_array_adapter_id);
        }
        onBindViewHolder(holder, item, position);
        return holder.itemView;
    }
}
