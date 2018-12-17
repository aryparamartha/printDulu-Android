package com.example.aryparamartha.printit.Vendor.Profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.LoginActivity;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.model.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorProfileFragment extends Fragment implements View.OnClickListener {
    PreferencesHelper preferencesHelper;

    EditText nama_adm, hp_adm, alamat_adm;
    Button logout, saveProfile;
    private Profile profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_admin,container,false);

        nama_adm = view.findViewById(R.id.vendorName);
        hp_adm = view.findViewById(R.id.vendorPhone);
        alamat_adm = view.findViewById(R.id.vendorAddress);

        logout = view.findViewById(R.id.vendorButtonLogOut);
        saveProfile = view.findViewById(R.id.vendorButtonSave);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        preferencesHelper = new PreferencesHelper(getActivity());
        logout.setOnClickListener(this);
        saveProfile.setOnClickListener(this);

//        Toast.makeText(getActivity(), ""+preferencesHelper.getToken(), Toast.LENGTH_SHORT).show();
        showProfile();
    }

    private void showProfile() {
        ApiClient.getService(getActivity())
                .profile()
                .enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        if (response.isSuccessful()){
                            profile = response.body();
//                            Toast.makeText(getContext(), ""+profile.getName(), Toast.LENGTH_SHORT).show();
                            nama_adm.setText(profile.getName());
                            hp_adm.setText(profile.getPhone());
                            alamat_adm.setText(profile.getAddress());
                        }else {
                            Toast.makeText(getContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vendorButtonLogOut:
                preferencesHelper.logout();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                getActivity().startActivity(intent);
                SharedPreferences pref = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                getActivity().finish();
                break;
            case R.id.vendorButtonSave:
//                save();
                break;
        }
    }
}
