package com.example.buay_app.TipsModel;

import java.util.List;

public class AllCategory {

    String categoryTitle;
    List<TipsCategoryItem> categoryItemList;

    public AllCategory(String categoryTitle, List<TipsCategoryItem> categoryItemList) {
        this.categoryTitle = categoryTitle;
        this.categoryItemList = categoryItemList;
    }

    public List<TipsCategoryItem> getCategoryItemList() {
        return categoryItemList;
    }

    public void setCategoryItemList(List<TipsCategoryItem> categoryItemList) {
        this.categoryItemList = categoryItemList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
