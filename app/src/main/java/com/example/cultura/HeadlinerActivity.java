package com.example.cultura;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class HeadlinerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headliner);


        viewPager=findViewById(R.id.headlinerActivityViewPager);

        HeadlinerActivityAdapter headlinerActivityAdapter = new HeadlinerActivityAdapter(this);
        viewPager.setAdapter(headlinerActivityAdapter);


    }
}
