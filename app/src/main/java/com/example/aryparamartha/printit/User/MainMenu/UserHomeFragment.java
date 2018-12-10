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
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserTrans;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserHomeFragment extends Fragment implements FilleAdapter.OnClickListener{
    private RecyclerView mRecyclerView;
    private FilleAdapter mAdapter;
    private List<UserTrans> fileList;
    FloatingActionButton btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.profile_rv);
        btnAdd = view.findViewById(R.id.addTrans);
        return view;
    }

    /*public void changeItem(int position, String text){
        fileList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }*/

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<FileItem> fileList = new ArrayList<>();
//        fileList.add(new FileItem(R.drawable.file, "File 1", "Detail File 1"));
//        fileList.add(new FileItem(R.drawable.file, "File 2", "Detail File 2"));
//        fileList.add(new FileItem(R.drawable.file, "File 3", "Detail File 3"));
//
//        mRecyclerView.setHasFixedSize(true);
//        mLayoutManager = new LinearLayoutManager(this.getActivity());
//        mAdapter = new FileAdapter(fileList);
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddTransUser.class);
                startActivity(intent);
            }
        });

        showFile();
    }

    private void showFile() {
        ApiClient.getService(getContext())
                .showTransaction()
                .enqueue(new Callback<List<UserTrans>>() {
                    @Override
                    public void onResponse(Call<List<UserTrans>> call, Response<List<UserTrans>> response) {
                        if (response.isSuccessful()){
                            fileList = response.body();
                            setAdapter();
                        }else {
                            Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserTrans>> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(int position) {
        UserTrans userTrans = fileList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DetailFileActivity.KEY_FILE, userTrans);
        Intent intent = new Intent(getContext(), DetailFileActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setAdapter(){
        mAdapter = new FilleAdapter(getContext(), fileList);
        mAdapter.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
