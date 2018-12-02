package com.example.aryparamartha.printit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private ArrayList<LocationItem> mLocationList;

    public static class LocationViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.loc_img);
            mTextView1 = itemView.findViewById(R.id.loc_name);
            mTextView2 = itemView.findViewById(R.id.loc_address);
        }
    }

    public LocationAdapter(ArrayList<LocationItem> locationList){
        mLocationList = locationList;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_item, viewGroup, false);
        LocationAdapter.LocationViewHolder lvh = new LocationViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder locationViewHolder, int i) {
        LocationItem currentLocation = mLocationList.get(i);


        locationViewHolder.mImageView.setImageResource(R.drawable.location);
        locationViewHolder.mTextView1.setText(currentLocation.getmLocName());
        locationViewHolder.mTextView2.setText(currentLocation.getmLocAddress());
    }

    @Override
    public int getItemCount() {
        return mLocationList.size();
    }
}
