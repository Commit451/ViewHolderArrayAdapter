package com.commit451.viewholderarrayadapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Simple implementation which calls the {@link Object#toString()} on whatever object is passed. Similar
 * to a normal {@link android.widget.ArrayAdapter} you would use with a spinner, it expects that the custom
 * ViewHolder layout you provide at least contains a TextView with an id of android.R.id.text1
 */
public class TextSingleViewHolderArrayAdapter<T> extends SingleViewHolderArrayAdapter<T, TextViewHolder<T>> {

    @LayoutRes
    private int layoutRes = -1;

    /**
     * Construct an adapter with your provided data and custom layout resource
     * @param context context
     * @param layoutRes the custom layout resource. Make sure you have a {@link android.widget.TextView} with an id of android.R.id.text1
     * @param objects the items, which will get their title via {@link Object#toString()}
     */
    public TextSingleViewHolderArrayAdapter(Context context, @LayoutRes int layoutRes, List<T> objects) {
        super(context, objects);
        this.layoutRes = layoutRes;
    }

    @NonNull
    @Override
    protected TextViewHolder<T> onCreateSingleViewHolder(@NonNull ViewGroup parent) {
        if (layoutRes == -1) {
            throw new IllegalStateException("You must provide a valid layout resource");
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutRes, parent, false);
        TextViewHolder<T> holder = new TextViewHolder<>(view);
        if (holder.text == null) {
            throw new IllegalArgumentException("The layout you provide must have a TextView with a layout id of android.R.id.text1");
        }
        return holder;
    }

    @Override
    protected void onBindSingleViewHolder(@NonNull TextViewHolder<T> holder, T item, int position) {
        holder.bind(item);
    }
}