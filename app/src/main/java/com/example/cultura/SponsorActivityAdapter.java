package com.example.cultura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;



public class SponsorActivityAdapter extends RecyclerView.Adapter<SponsorActivityAdapter.SponsorViewHolder> {



    private Context context;


    private List<Sponsor> SponsorList;
    public class SponsorViewHolder extends RecyclerView.ViewHolder {

        TextView sponsorNameTextView;
        ImageView sponsorLogoImage;

        public SponsorViewHolder(View itemView) {
            super(itemView);

            sponsorNameTextView = itemView.findViewById(R.id.sponsorNameTextView);
            sponsorLogoImage= itemView.findViewById(R.id.sponsorLogoImageCardView);
        }
    }


    public SponsorActivityAdapter(Context context, List<Sponsor> SponsorList) {
        this.context = context;
        this.SponsorList = SponsorList;

    }

    @Override
    public SponsorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sponsor_card_view, null);
        return new SponsorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SponsorViewHolder holder, int position) {

        Sponsor sponsor = SponsorList.get(position);


        holder.sponsorNameTextView.setText(sponsor.getName());

        holder.sponsorLogoImage.setImageDrawable(context.getResources().getDrawable(sponsor.getImage()));

    }


    @Override
    public int getItemCount() {
        return SponsorList.size();
    }



}