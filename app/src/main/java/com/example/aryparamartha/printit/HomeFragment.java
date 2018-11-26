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

public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ArrayList<FileItem> fileList = new ArrayList<>();
//        fileList.add(new FileItem(R.drawable.file, "File 1", "Detail File 1"));
//        fileList.add(new FileItem(R.drawable.file, "File 2", "Detail File 2"));
//        fileList.add(new FileItem(R.drawable.file, "File 3", "Detail File 3"));
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

//        ArrayList<FileItem> fileList = new ArrayList<>();
//        fileList.add(new FileItem(R.drawable.file, "File 1", "Detail File 1"));
//        fileList.add(new FileItem(R.drawable.file, "File 2", "Detail File 2"));
//        fileList.add(new FileItem(R.drawable.file, "File 3", "Detail File 3"));
//
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this.getActivity());
//        mAdapter = new FileAdapter(fileList);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

        return view;

//        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<FileItem> fileList = new ArrayList<>();
        fileList.add(new FileItem(R.drawable.file, "File 1", "Detail File 1"));
        fileList.add(new FileItem(R.drawable.file, "File 2", "Detail File 2"));
        fileList.add(new FileItem(R.drawable.file, "File 3", "Detail File 3"));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mAdapter = new FileAdapter(fileList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
