package com.example.cultura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Events_Adapter mAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<EventsItem> eventList = new ArrayList<>();
        eventList.add(new EventsItem(R.drawable.ic_art, "Art"));
        eventList.add(new EventsItem(R.drawable.ic_dance, "Dance"));
        eventList.add(new EventsItem(R.drawable.ic_music, "Music"));
        eventList.add(new EventsItem(R.drawable.ic_photography, "Photography"));
        eventList.add(new EventsItem(R.drawable.ic_technical, "Technical"));
        eventList.add(new EventsItem(R.drawable.ic_theatre, "Theatre"));
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Events_Adapter(eventList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new Events_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                final Intent intent;
                switch(position){
                    case 0: intent = new Intent(mContext, Art.class); break;
                    case 1: intent = new Intent(mContext, Dance.class); break;
                    case 2: intent = new Intent(mContext, Music.class); break;
                    case 3: intent = new Intent(mContext, Photography.class); break;
                    case 4: intent = new Intent(mContext, Technical.class); break;
                    case 5: intent = new Intent(mContext, Theatre.class); break;
                    default: intent = new Intent(mContext, MainActivity.class);
                }
                mContext.startActivity(intent);
            }
        });
    }
}
