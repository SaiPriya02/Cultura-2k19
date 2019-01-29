package com.example.cultura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //ImageButton headlinerButton=findViewById(R.id.headlinersButton);
        CardView headlinersCard = findViewById(R.id.headlinersCard);
        CardView eventsCard = findViewById(R.id.eventsCard);
        CardView registrationsCard = findViewById(R.id.registrationsCard);
        CardView sponsorsCard = findViewById(R.id.sponsorsCard);
        CardView aboutCard = findViewById(R.id.aboutCard);

        headlinersCard.setCardBackgroundColor(0xFF3F51B5);
        eventsCard.setCardBackgroundColor(0xFF4CAF50);
        registrationsCard.setCardBackgroundColor(0xFFFFC107);
        sponsorsCard.setCardBackgroundColor(0xFF607D8B);
        aboutCard.setCardBackgroundColor(0xFFf44336);

        Button headlinersButton = findViewById(R.id.headlinersButton);
        Button eventsButton = findViewById(R.id.eventsButton);
        Button registrationsButton = findViewById(R.id.registrationsButton);
        Button sponsorsButton = findViewById(R.id.sponsorsButton);
        Button aboutButton = findViewById(R.id.aboutButton);

        headlinersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), HeadlinerActivity.class);
                startActivity(i);
            }
        });

        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), EventsActivity.class);
                startActivity(i);
            }
        });

        registrationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        sponsorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SponActivity.class);
                startActivity(i);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AboutActivity.class);
                startActivity(i);
            }
        });
    }
}
