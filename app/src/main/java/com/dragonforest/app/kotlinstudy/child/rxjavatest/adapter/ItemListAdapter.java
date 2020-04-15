// (c)2016 Flipboard Inc, All Rights Reserved.

package com.dragonforest.app.kotlinstudy.child.rxjavatest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dragonforest.app.kotlinstudy.R;
import com.dragonforest.app.kotlinstudy.child.rxjavatest.model.Item;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter {
    List<Item> images;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        Item image = images.get(position);
        Glide.with(holder.itemView.getContext()).load(image.imageUrl).into(debounceViewHolder.imageIv);
        debounceViewHolder.descriptionTv.setText(image.description);
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    public void setItems(List<Item> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {
        ImageView imageIv;
        TextView descriptionTv;
        public DebounceViewHolder(View itemView) {
            super(itemView);
            imageIv=itemView.findViewById(R.id.imageIv);
            descriptionTv=itemView.findViewById(R.id.descriptionTv);
        }
    }

}
