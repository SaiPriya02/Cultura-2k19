package com.example.cultura;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Art extends MainActivity implements Art_Adapter.OnItemClickListener {

    private RecyclerView aRecyclerView;
    private Art_Adapter aAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager aLayoutManager;
    private Context aContext = this;
    final ArrayList<ArtItem> artList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //art_main is redundant

        artList.add(new ArtItem("Art Event 1"));
        artList.add(new ArtItem("Art Event 2"));
        artList.add(new ArtItem("Art Event 3"));
        artList.add(new ArtItem("Art Event 4"));
        artList.add(new ArtItem("Art Event 5"));
        aRecyclerView = findViewById(R.id.recyclerView);
        aRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        aLayoutManager = new LinearLayoutManager(this);
        aAdapter = new Art_Adapter(artList);
        aRecyclerView.setLayoutManager(aLayoutManager);
        aRecyclerView.setAdapter(aAdapter);

       /* aAdapter.setOnItemClickListener(new Art_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
             //  String txt = artList.get(position).getmText(); //get(position).<call function here>
                Intent intent = new Intent(aContext, InfoActivity.class);
              //   intent.putExtra("event_name", artList.get(position)); //check what needs to replace artList
                startActivity(intent);

            }
        }); */
    }

    @Override
    public void onItemClick(int position) { //you might have to delete this, idk look at the video
        //mNotes in video is equivalent to artList
        artList.get(position);
        Intent intent = new Intent(aContext, InfoActivity.class);
        startActivity(intent);
    }
}