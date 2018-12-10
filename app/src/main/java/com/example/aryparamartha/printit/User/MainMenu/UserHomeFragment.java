package com.example.aryparamartha.printit.User.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aryparamartha.printit.R;

import java.util.ArrayList;

public class UserHomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FileAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<FileItem> fileList;
    FloatingActionButton btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.profile_rv);
        btnAdd = view.findViewById(R.id.addTrans);
        return view;
    }

    public void changeItem(int position, String text){
        fileList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<FileItem> fileList = new ArrayList<>();
        fileList.add(new FileItem(R.drawable.file, "File 1", "Detail File 1"));
        fileList.add(new FileItem(R.drawable.file, "File 2", "Detail File 2"));
        fileList.add(new FileItem(R.drawable.file, "File 3", "Detail File 3"));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mAdapter = new FileAdapter(fileList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new FileAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position) {
                fileList.get(position).changeText1("Clicked");
                mAdapter.notifyItemChanged(position);
                Intent intent = new Intent(getActivity(), UserMainActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddUserTrans.class);
                startActivity(intent);
            }
        });
    }
}
