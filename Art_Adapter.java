package com.example.cultura;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Art_Adapter extends RecyclerView.Adapter<Art_Adapter.ArtViewHolder> {

    private ArrayList<ArtItem> mArtList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    } //redundant?
    public static class ArtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //the onClick that is done in here is now outside the function(notes video)

        public TextView atextView;
        OnItemClickListener listener;

        public ArtViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            atextView = itemView.findViewById(R.id.textView_art);

        /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) { //to check if it has been clicked
                        int position = getAdapterPosition(); //get adapter position
                        if (position != RecyclerView.NO_POSITION) {    //to check if the position is actually valid
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

    public Art_Adapter(ArrayList<ArtItem> artList, OnItemClickListener listener) {
        mArtList = artList;
        mListener = listener;
    } //constructor

    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false);
        ArtViewHolder avh = new ArtViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return avh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        ArtItem currentItem = mArtList.get(position);
        holder.atextView.setText(currentItem.getmText()); //getmText() is in ArtItem.java
    }

    @Override
    public int getItemCount() {
        return mArtList.size();
    }
}
