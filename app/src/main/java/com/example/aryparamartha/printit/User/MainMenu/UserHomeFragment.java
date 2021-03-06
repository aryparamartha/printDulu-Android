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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.DatabaseHelper;
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
    private ViewFlipper simpleViewFlipper;
    int[] images = {R.drawable.promo1, R.drawable.promo2, R.drawable.promo3};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.profile_rv);
        btnAdd = view.findViewById(R.id.addTrans);
        simpleViewFlipper = (ViewFlipper) view.findViewById(R.id.flipper_view);

        for(int i=0; i<images.length; i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(images[i]);
            simpleViewFlipper.addView(imageView);
        }

        Animation in = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right);

        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);
        simpleViewFlipper.setFlipInterval(3000);
        simpleViewFlipper.setAutoStart(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<FileItem> fileList = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateTransActivity.class);
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
                            DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
//                            databaseHelper.deleteTransaction();
                            fileList = response.body();

                            for (UserTrans userTrans:fileList){
                                databaseHelper.insertTransaction(userTrans.getCreatedAt(), userTrans.getFormatFile(), userTrans.getIdTrans()
                                ,userTrans.getFileLocation(), userTrans.getNamaFile(), userTrans.getId(),userTrans.getTransFile()
                                        ,userTrans.getTransTotal(),userTrans.getUpdatedAt(),userTrans.getIdUser());
                            }
                            setAdapter();
                        }else {
                            Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserTrans>> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                        fileList = databaseHelper.selectTrans();
                        setAdapter();
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
