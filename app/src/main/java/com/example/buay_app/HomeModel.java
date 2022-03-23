package com.example.buay_app;

public class HomeModel {

        String name, title, description, vurl;
        int counter;
    HomeModel()
    {

    }
    public HomeModel(String name, String title, String description, String vurl, int counter) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.vurl = vurl;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
