package com.example.cultura;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Theatre_Adapter extends RecyclerView.Adapter<Theatre_Adapter.TheatreViewHolder> {

    private ArrayList<TheatreItem> mTheatreList;
    OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class TheatreViewHolder extends RecyclerView.ViewHolder {

        public TextView thtextView;

        public TheatreViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            thtextView = itemView.findViewById(R.id.textView_art);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){ //to check if it has been clicked
                        int position = getAdapterPosition(); //get adapter position
                        if(position != RecyclerView.NO_POSITION){    //to check if the position is actually valid
                            listener.onItemClick(position); //pass to interface function
                        }
                    }
                }
            });

        }
    }

    public Theatre_Adapter(ArrayList<TheatreItem> theatreList) { mTheatreList = theatreList; } //constructor

    @NonNull
    @Override
    public TheatreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false);
        TheatreViewHolder thvh = new TheatreViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return thvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TheatreViewHolder holder, int position) {
        TheatreItem currentItem = mTheatreList.get(position);
        holder.thtextView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mTheatreList.size();
    }
}
