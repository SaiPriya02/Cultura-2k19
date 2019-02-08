package com.example.cultura;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Dance extends MainActivity implements Dance_Adapter.OnItemClickListener {

    private RecyclerView dRecyclerView;
    private Dance_Adapter dAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager dLayoutManager;
    private Context dContext = this;
    final ArrayList<DanceItem> danceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //dance_main is redundant so its been removed

        danceList.add(new DanceItem("Dance Event 1"));
        danceList.add(new DanceItem("Dance Event 2"));
        danceList.add(new DanceItem("Dance Event 3"));
        danceList.add(new DanceItem("Dance Event 4"));
        danceList.add(new DanceItem("Dance Event 5"));
        dRecyclerView = findViewById(R.id.recyclerView);
        dRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        dLayoutManager = new LinearLayoutManager(this);
        dAdapter = new Dance_Adapter(danceList, this);
        dRecyclerView.setLayoutManager(dLayoutManager);
        dRecyclerView.setAdapter(dAdapter);

      /*  dAdapter.setOnItemClickListener(new Dance_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                danceList.get(position); //get(position).<call function here>

                // Intent intent = new Intent(aContext, Art.class); //but this has to change depending on  which card is clicked //also change this
                //   startActivity(intent);
            }
        }); */

    }

    @Override
    public void onItemClick(int position) {
        //danceList.get(position);
        Intent intent = new Intent(dContext, InfoActivity.class);
        intent.putExtra("event name", "position of the event");
        //intent.putExtra("event_name", artList.get(position)); //this gives an error because it has a hardcoded thing
        startActivity(intent);
    }
}