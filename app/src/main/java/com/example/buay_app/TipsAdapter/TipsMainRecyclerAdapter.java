package com.example.buay_app.TipsAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buay_app.R;
import com.example.buay_app.TipsModel.AllCategory;
import com.example.buay_app.TipsModel.TipsCategoryItem;

import java.util.List;

public class TipsMainRecyclerAdapter extends RecyclerView.Adapter<TipsMainRecyclerAdapter.TipsMainViewHolder> {

    private Context context;
    private List<AllCategory> allCategoryList;

    public TipsMainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public TipsMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TipsMainViewHolder(LayoutInflater.from(context).inflate(R.layout.tips_main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TipsMainViewHolder holder, int position) {
        holder.categoryTitle.setText(allCategoryList.get(position).getCategoryTitle());
        setCategoryItemRecycler(holder.itemRecycler, allCategoryList.get(position).getCategoryItemList());
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class TipsMainViewHolder extends RecyclerView.ViewHolder{

        TextView categoryTitle;
        RecyclerView itemRecycler;

        public TipsMainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle=itemView.findViewById(R.id.category_title_textView);
            itemRecycler=itemView.findViewById(R.id.item_recycler);
        }
    }

    private void setCategoryItemRecycler(RecyclerView recyclerView, List<TipsCategoryItem> categoryItemList){
        TipsCategoryItemRecyclerAdapter itemRecyclerAdapter = new TipsCategoryItemRecyclerAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }

}
