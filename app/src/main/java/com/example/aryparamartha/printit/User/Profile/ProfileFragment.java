package com.example.aryparamartha.printit.User.Profile;

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

public class ProfileFragment extends Fragment implements View.OnClickListener{

    EditText nama_user, hp_user, alamat_user;
    Button logout, saveProfile;
    Profile profile;
    private PreferencesHelper preferencesHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nama_user = view.findViewById(R.id.nama_user);
        hp_user = view.findViewById(R.id.hp_user);
        alamat_user = view.findViewById(R.id.alamat_user);

        logout = view.findViewById(R.id.buttonLogOut);
        saveProfile = view.findViewById(R.id.save_profile);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        logout.setOnClickListener(this);
        saveProfile.setOnClickListener(this);

        preferencesHelper = new PreferencesHelper(getActivity());

        showProfile();
    }

    private void showProfile() {
        ApiClient.getService(getContext())
                .profile()
                .enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        if (response.isSuccessful()){
                            profile = response.body();
                            nama_user.setText(profile.getName());
                            hp_user.setText(profile.getPhone());
                            alamat_user.setText(profile.getAddress());
                        } else {
                            Toast.makeText(getContext(), "Request Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Toast.makeText(getContext(), "Request Invalid", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogOut:
                preferencesHelper.logout();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                getActivity().startActivity(intent);
                SharedPreferences pref = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                getActivity().finish();
                break;
            case R.id.save_profile:
                save();
                break;
        }
    }

    private void save() {
    }
}
