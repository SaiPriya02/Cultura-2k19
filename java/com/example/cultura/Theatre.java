package com.example.cultura;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Theatre extends MainActivity implements Theatre_Adapter.OnItemClickListener {

    private RecyclerView tRecyclerView; //this is not being used wth
    private Theatre_Adapter tAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager tLayoutManager;
    private Context tContext = this;
    final ArrayList<TheatreItem> theatreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //art_main is redundant

        theatreList.add(new TheatreItem("Theatre Event 1"));
        theatreList.add(new TheatreItem("Theatre Event 2"));
        theatreList.add(new TheatreItem("Theatre Event 3"));
        theatreList.add(new TheatreItem("Theatre Event 4"));
        theatreList.add(new TheatreItem("Theatre Event 5"));

        tRecyclerView = findViewById(R.id.recyclerView);
        tRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        tLayoutManager = new LinearLayoutManager(this);
        tAdapter = new Theatre_Adapter(theatreList);
        tRecyclerView.setLayoutManager(tLayoutManager);
        tRecyclerView.setAdapter(tAdapter);

       /* tAdapter.setOnItemClickListener(new Theatre_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                theatreList.get(position); //get(position).<call function here>
                // Intent intent = new Intent(mContext, Art.class); //but this has to change depending on  which card is clicked //also change this
                //   startActivity(intent);
            }
        }); */
    }

    @Override
    public void onItemClick(int position) {
        theatreList.get(position);
        //get from Art.java
    }
}
