package com.example.cultura;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Tech_Adapter extends RecyclerView.Adapter<Tech_Adapter.TechViewHolder> {

    private ArrayList<TechItem> mtechList;
    OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class TechViewHolder extends RecyclerView.ViewHolder {

        public TextView tetextView;


        public TechViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tetextView = itemView.findViewById(R.id.textView_art);

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

    public Tech_Adapter(ArrayList<TechItem> techList) {
        mtechList = techList;
    } //constructor


    @NonNull
    @Override
    public TechViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false);
        TechViewHolder tvh = new TechViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TechViewHolder holder, int position) {
        TechItem currentItem = mtechList.get(position);
        holder.tetextView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mtechList.size();
    }
}
