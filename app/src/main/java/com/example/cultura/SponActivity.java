package com.example.cultura;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SponActivity extends AppCompatActivity {

    //a list to store all the sponsors later linked to the server
    List<Sponsor> SponsorList;


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spon);

        recyclerView =  findViewById(R.id.sponsorActivityRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


       SponsorList = new ArrayList<>();



       SponsorList.add(
                new Sponsor(
                        "Google", R.drawable.ic_launcher_foreground));

       SponsorList.add(
                new Sponsor(

                        "Apple", R.drawable.ic_launcher_foreground));
        SponsorList.add(
                new Sponsor(

                        "Microsoft", R.drawable.ic_launcher_foreground));
        SponsorList.add(
                new Sponsor(

                        "Tesla", R.drawable.ic_launcher_foreground));
        SponsorList.add(
                new Sponsor(

                        "Bhadwe", R.drawable.ic_launcher_foreground));


        SponsorActivityAdapter adapter = new SponsorActivityAdapter(this, SponsorList);


        recyclerView.setAdapter(adapter);
    }
}