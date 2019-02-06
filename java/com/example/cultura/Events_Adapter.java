package com.example.cultura;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class Events_Adapter extends RecyclerView.Adapter<Events_Adapter.EventsViewHolder> {

    private ArrayList<EventsItem> mEventsList;

    OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }

    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder {

        public ImageView mimageView;
        public TextView mtextView;


        public EventsViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.imageView);
            mtextView = itemView.findViewById(R.id.textView);

            /*on click functions*/
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

    public Events_Adapter(ArrayList<EventsItem> eventList) {
        mEventsList = eventList;
    } //constructor

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_item, parent, false);
        EventsViewHolder evh = new EventsViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return evh;
    } //27 jan 2019, 10.45pm

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        EventsItem currentItem = mEventsList.get(position);
        holder.mimageView.setImageResource(currentItem.getIconResource()); //getIconResource is in EventsItem.java
        holder.mtextView.setText(currentItem.getmText()); //so is getmText()

    }

    @Override
    public int getItemCount() {
        return mEventsList.size();
    }
}