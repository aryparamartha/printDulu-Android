package com.example.aryparamartha.printit.User.Location;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserVendor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationFragment extends Fragment {

    View v;

    private RecyclerView mLocation;
    private List<UserVendor> listLoc = new ArrayList<>();
    private LocationnAdapter  adapter;

    public LocationFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_location, container, false);
        mLocation = (RecyclerView) v.findViewById(R.id.location_rv);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showVender();
    }

    private void showVender() {
        ApiClient.getService(getContext())
                .showVendor()
                .enqueue(new Callback<List<UserVendor>>() {
                    @Override
                    public void onResponse(Call<List<UserVendor>> call, Response<List<UserVendor>> response) {
                        if (response.isSuccessful()){
                            listLoc = response.body();
                            adapter = new LocationnAdapter(getContext(), listLoc);
                            mLocation.setLayoutManager(new LinearLayoutManager(getContext()));
                            mLocation.setAdapter(adapter);
                        }else {
                            Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserVendor>> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
