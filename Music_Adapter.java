package com.example.cultura;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Music_Adapter extends RecyclerView.Adapter<Music_Adapter.MusicViewHolder> {

    private ArrayList<MusicItem> mMusicList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mtextView;
        OnItemClickListener listener;

        public MusicViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            mtextView = itemView.findViewById(R.id.textView_art);

           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){ //to check if it has been clicked
                        int position = getAdapterPosition(); //get adapter position
                        if(position != RecyclerView.NO_POSITION){    //to check if the position is actually valid
                            listener.onItemClick(position); //pass to interface function
                        }
                    }
                }
            }); */
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }

    public Music_Adapter(ArrayList<MusicItem> musicList, OnItemClickListener listener) {
        mMusicList = musicList;
        mListener = listener;

    } //constructor

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false);
        MusicViewHolder mvh = new MusicViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        MusicItem currentItem = mMusicList.get(position);
        holder.mtextView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mMusicList.size();
    }
}
