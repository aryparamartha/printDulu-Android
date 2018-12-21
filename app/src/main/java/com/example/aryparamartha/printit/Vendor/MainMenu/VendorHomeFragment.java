package com.example.aryparamartha.printit.Vendor.MainMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.DatabaseHelper;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.VendorTrans;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorHomeFragment extends Fragment implements VendorFileAdapter.OnClickListener{
    private RecyclerView mRecyclerView;
    private VendorFileAdapter mAdapter;
    private List<VendorTrans> vendorFileList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_admin,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.transaksiVendor_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<VendorFileItem> vendorFileList = new ArrayList<>();
        showFile();
    }

    private void showFile() {
        ApiClient.getService(getContext())
                .showTransactionVendor()
                .enqueue(new Callback<List<VendorTrans>>() {
                    @Override
                    public void onResponse(Call<List<VendorTrans>> call, Response<List<VendorTrans>> response) {
                        if (response.isSuccessful()){
                            DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
//                            databaseHelper.deleteTransaction();
                            vendorFileList= response.body();

                            for (VendorTrans vendorTrans:vendorFileList){
                                databaseHelper.insertTransaction(vendorTrans.getCreatedAt(), vendorTrans.getFormatFile(), vendorTrans.getIdTrans()
                                        ,vendorTrans.getFileLocation(), vendorTrans.getNamaFile(), vendorTrans.getId(),vendorTrans.getTransFile()
                                        ,vendorTrans.getTransTotal(),vendorTrans.getUpdatedAt(),vendorTrans.getIdUser());
                            }
                            Log.d("response",response.body().toString());
                            setAdapter();
                        }else {
                            Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<VendorTrans>> call, Throwable t) {
                        Toast.makeText(getContext(), "Error: "+t, Toast.LENGTH_SHORT).show();
                        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                        vendorFileList = databaseHelper.selectVendorTrans();
                        setAdapter();
                    }
                });
    }

    @Override
    public void onClick(int position) {
        VendorTrans vendorTrans= vendorFileList.get(position);
        Bundle bundle = new Bundle();
        bundle.putParcelable(VendorDetailFileActivity.KEY_FILE, vendorTrans);
        Intent intent = new Intent(getContext(), VendorDetailFileActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setAdapter(){
        mAdapter = new VendorFileAdapter(getContext(),vendorFileList);
        mAdapter.setOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
    }
}
