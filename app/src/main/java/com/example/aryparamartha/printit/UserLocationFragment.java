package com.example.aryparamartha.printit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class UserLocationFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.location_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<LocationItem> locList = new ArrayList<>();
        locList.add(new LocationItem(R.drawable.location, "Lokasi 1", "Jalan Bukit 1"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 2", "Jalan Bukit 2"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 3", "Jalan Bukit 3"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 4", "Jalan Bukit 4"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 5", "Jalan Bukit 5"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 6", "Jalan Bukit 6"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 7", "Jalan Bukit 7"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 8", "Jalan Bukit 8"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 9", "Jalan Bukit 9"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 10", "Jalan Bukit 10"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 11", "Jalan Bukit 11"));
        locList.add(new LocationItem(R.drawable.location, "Lokasi 12", "Jalan Bukit 12"));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mAdapter = new LocationAdapter(locList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
