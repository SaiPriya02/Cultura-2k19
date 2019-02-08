package com.example.cultura;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class Music extends MainActivity implements Music_Adapter.OnItemClickListener {

    private RecyclerView mRecyclerView; //this is not being used wth
    private Music_Adapter mAdapter; //this is changed from RecyclerView.Adapter to use the custom methods that we made
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext = this;
    final ArrayList<MusicItem> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //art_main is redundant

        musicList.add(new MusicItem("Music Event 1"));
        musicList.add(new MusicItem("Music Event 2"));
        musicList.add(new MusicItem("Music Event 3"));
        musicList.add(new MusicItem("Music Event 4"));
        musicList.add(new MusicItem("Music Event 5"));
        musicList.add(new MusicItem("Music Event 6"));
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); //if the recyclerView won't change in size, no matter the content
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Music_Adapter(musicList, this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        /*mAdapter.setOnItemClickListener(new Music_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                musicList.get(position); //get(position).<call function here>
                // Intent intent = new Intent(mContext, Art.class); //but this has to change depending on  which card is clicked //also change this
                //   startActivity(intent);
            }
        }); */
    }

    @Override
    public void onItemClick(int position) {
       // musicList.get(position);
        Intent intent = new Intent(mContext, InfoActivity.class);
        intent.putExtra("event name", "position of the event");
        startActivity(intent);
    }
}
