package com.example.buay_app;

public class HomeModel {

        String name, title, description, vurl, Uid;
        //int counter;
    HomeModel()
    {

    }
    //need to add user.id
    public HomeModel(String name, String title, String description, String vurl, String uid) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.vurl = vurl;
        this.Uid = uid;
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
    public String getUid() {return Uid;}
   // public void setUid(String uid) {this.Uid = uid; }
}
