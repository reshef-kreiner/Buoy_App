package com.example.buay_app.TipsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buay_app.R;
import com.example.buay_app.TipsModel.TipsCategoryItem;

import java.util.List;

public class TipsCategoryItemRecyclerAdapter extends RecyclerView.Adapter<TipsCategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<TipsCategoryItem> categoryItemList;

    public TipsCategoryItemRecyclerAdapter(Context context, List<TipsCategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
            holder.itemImage.setImageResource(categoryItemList.get(position).getimageUrl());
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemTitle;
        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image_imageView);
            itemTitle = itemView.findViewById(R.id.item_title);

        }
    }
}
