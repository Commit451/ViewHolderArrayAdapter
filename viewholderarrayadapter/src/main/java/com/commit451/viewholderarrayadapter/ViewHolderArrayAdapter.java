package com.commit451.viewholderarrayadapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Uses the magic of {@link android.support.v7.widget.RecyclerView.ViewHolder}s with
 * {@link ArrayAdapter} to make great Spinner adapters
 */
public abstract class ViewHolderArrayAdapter<T, VH extends RecyclerView.ViewHolder> extends ArrayAdapter<T> {

    /**
     * Called when Spinner needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(RecyclerView.ViewHolder, Object, int)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see android.support.v7.widget.RecyclerView.Adapter#onCreateViewHolder(ViewGroup, int)
     * @see #onBindViewHolder(RecyclerView.ViewHolder, Object, int)
     */
    @NonNull
    protected abstract VH onCreateViewHolder(@NonNull ViewGroup parent);

    /**
     * Called by Spinner to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param item The item that should be bound
     * @param position The position of the item within the adapter's data set.
     */
    protected abstract void onBindViewHolder(@NonNull VH holder, T item, int position);

    public ViewHolderArrayAdapter(Context context, List<T> objects) {
        super(context, 0, objects);
    }

    @Override
    public void setDropDownViewResource(int resource) {
        throwIt();
    }

    private void throwIt() {
        throw new RuntimeException("This is not supported due to the need to use ViewHolders. You should extend this class and customize as needed.");
    }

    @CallSuper
    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getTheView(position, convertView, parent);
    }

    @CallSuper
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getTheView(position, convertView, parent);
    }

    private View getTheView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        T item = getItem(position);
        VH holder;
        if (convertView == null) {
            holder = onCreateViewHolder(parent);
            holder.itemView.setTag(R.id.view_holder_array_adapter_id, holder);
        } else {
            //no need to worry, we are the only ones setting this tag
            //noinspection unchecked
            holder = (VH) convertView.getTag(R.id.view_holder_array_adapter_id);
        }
        onBindViewHolder(holder, item, position);
        return holder.itemView;
    }
}
