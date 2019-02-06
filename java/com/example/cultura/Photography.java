package com.example.cultura;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Photography extends MainActivity implements Photo_Adapter.OnItemClickListener {

    private RecyclerView pRecyclerView; //this is not being used wth
    private Photo_Adapter pAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager pLayoutManager;
    private Context pContext = this;
    final ArrayList<PhotoItem> photoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //art_main is redundant

        photoList.add(new PhotoItem("Photography Event 1"));
        photoList.add(new PhotoItem("Photography Event 2"));
        photoList.add(new PhotoItem("Photography Event 3"));
        photoList.add(new PhotoItem("Photography Event 4"));
        photoList.add(new PhotoItem("Photography Event 5"));
        pRecyclerView = findViewById(R.id.recyclerView);
        pRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        pLayoutManager = new LinearLayoutManager(this);
        pAdapter = new Photo_Adapter(photoList);
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setAdapter(pAdapter);

      /*  pAdapter.setOnItemClickListener(new Photo_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                photoList.get(position); //get(position).<call function here>
                // Intent intent = new Intent(mContext, Art.class); //but this has to change depending on  which card is clicked //also change this
                //   startActivity(intent);
            }
        }); */
    }

    @Override
    public void onItemClick(int position) {
        photoList.get(position);
        //get from Art.java
    }
}