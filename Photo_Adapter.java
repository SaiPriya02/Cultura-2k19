package com.example.cultura;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Photo_Adapter extends RecyclerView.Adapter<Photo_Adapter.PhotoViewHolder> {

    private ArrayList<PhotoItem> mPhotoList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position); //this function is what should be called when you click
    }
    public void setOnItemClickListener(OnItemClickListener listener) { //get the click and position from adapter to main activity
        mListener = listener;
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView ptextView;
        OnItemClickListener listener;

        public PhotoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.listener = listener;
            ptextView = itemView.findViewById(R.id.textView_art);

            /*itemView.setOnClickListener(new View.OnClickListener() {
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

    public Photo_Adapter(ArrayList<PhotoItem> photoList, OnItemClickListener listener) {
        mPhotoList = photoList;
        mListener = listener;
    } //constructor

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_item, parent, false);
        PhotoViewHolder pvh = new PhotoViewHolder(v, mListener); //you pass mListener here because you cant directly access it from the EventsViewHolder class because it is static
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        PhotoItem currentItem = mPhotoList.get(position);
        holder.ptextView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }
}
