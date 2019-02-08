package com.example.cultura;

import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Dance_Adapter extends RecyclerView.Adapter<Dance_Adapter.DanceViewHolder> {

    private ArrayList<DanceItem> mDanceList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class DanceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView dtextView;
        OnItemClickListener listener;

        public DanceViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            dtextView = itemView.findViewById(R.id.textView_art); //format is the same so textView_art is used

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

    public Dance_Adapter(ArrayList<DanceItem> DanceList, OnItemClickListener listener) {
        mDanceList = DanceList;
        mListener = listener;
    } //constructor

    @NonNull
    @Override
    public DanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false); //here also, try art then dance
        DanceViewHolder dvh = new DanceViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DanceViewHolder holder, int position) {
        DanceItem currentItem = mDanceList.get(position);
        holder.dtextView.setText(currentItem.getmText()); //getmText() is in ArtItem.java
    }

    @Override
    public int getItemCount() {
        return mDanceList.size();
    }
}