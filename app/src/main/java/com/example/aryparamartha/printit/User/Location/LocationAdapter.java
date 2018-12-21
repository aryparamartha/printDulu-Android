package com.example.aryparamartha.printit.User.Location;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.User.MainMenu.CreateTransActivity;
import com.example.aryparamartha.printit.model.UserVendor;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    Context mContext;
    List<UserVendor> mData;

    public LocationAdapter(Context mContext, List<UserVendor> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.location_item, viewGroup, false);
        LocationViewHolder vHolder = new LocationViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LocationViewHolder locationViewHolder, int i) {
        final UserVendor userVendor = mData.get(i);
        locationViewHolder.tv_locName.setText(userVendor.getName());
        locationViewHolder.tv_locAddress.setText(userVendor.getAddress());
        locationViewHolder.locImg.setImageResource(R.drawable.location);

        locationViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CreateTransActivity.class);
                intent.putExtra("name",userVendor.getName());
                intent.putExtra("idUser",userVendor.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_locName, tv_locAddress;
        private ImageView locImg;
        CardView cardView;
        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView =itemView.findViewById(R.id.locCard);
            tv_locName = (TextView) itemView.findViewById(R.id.loc_name);
            tv_locAddress= (TextView) itemView.findViewById(R.id.loc_address);
            locImg = (ImageView) itemView.findViewById(R.id.loc_img);
        }
    }
}
