package com.example.buay_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.buay_app.TipsAdapter.TipsMainRecyclerAdapter;
import com.example.buay_app.TipsModel.AllCategory;
import com.example.buay_app.TipsModel.TipsCategoryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.buay_app.R;

import java.util.ArrayList;
import java.util.List;

public class TipsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView mainCategoryRecycler;
    TipsMainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        //setting up the action bar background
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //the app image for the action bar - start
        actionBar.setDisplayShowCustomEnabled(true);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.header_image, null);
        actionBar.setCustomView(view);


        //adding category items to the Videos list inorder to display in the cardviews.
        List<TipsCategoryItem> videosCategoryItemList = new ArrayList<>();
        videosCategoryItemList.add(new TipsCategoryItem(1,"ימין או שמאל מאיזה שד הכי כדאי לך לינוק" , "WWW.youtube.com", R.drawable.baby_feeding_video_pic));
        videosCategoryItemList.add(new TipsCategoryItem(1,"טיפים מנצחים להנקה" , "WWW.youtube.com", R.drawable.winning_tips_video_pic));

        //adding category items to the Podcast list inorder to display in the cardviews.
        List<TipsCategoryItem> podcastsCategoryItemList = new ArrayList<>();
        podcastsCategoryItemList.add(new TipsCategoryItem(1,"כך תדאגי שתינוקך ישן לילה שלם" , "WWW.youtube.com", R.drawable.baby_sleep_podcast));
        podcastsCategoryItemList.add(new TipsCategoryItem(1,"האוכל הטוב ביותר לתינוק" , "WWW.youtube.com", R.drawable.baby_eat_podcast));

        //adding category items to the Article list inorder to display in the cardviews.
        List<TipsCategoryItem> articlesCategoryItemList = new ArrayList<>();
        articlesCategoryItemList.add(new TipsCategoryItem(1,"איך להיות אמא מאושרת" , "WWW.youtube.com", R.drawable.article_pic));

        //Recycler view code for the categories of the tips (vertical RV).
        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("סרטונים בנושא הנקה", videosCategoryItemList));
        allCategoryList.add(new AllCategory("פודקסטים בנושאי שינה ותזונה", podcastsCategoryItemList));
        allCategoryList.add(new AllCategory("כתבות במיוחד בשבילך", articlesCategoryItemList));

        setMainCategoryRecycler(allCategoryList);




        //Bottom navigation bar
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.tips);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tips:
                        return true;

                    case R.id.favorites:
                        startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }


    //Recycler view code for the tips.
    private void setMainCategoryRecycler(List<AllCategory> allCategoryList) {
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new TipsMainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);


    }
}