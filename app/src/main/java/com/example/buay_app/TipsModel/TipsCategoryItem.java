package com.example.buay_app.TipsModel;

public class TipsCategoryItem {

    Integer itemId;
    String title;
    String externalURL;
    Integer imageUrl;

    public TipsCategoryItem(Integer itemId, String title, String URL, Integer imageUrl) {
        this.itemId = itemId;
        this.title = title;
        this.externalURL = URL;
        this.imageUrl = imageUrl;

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }
    public Integer getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
