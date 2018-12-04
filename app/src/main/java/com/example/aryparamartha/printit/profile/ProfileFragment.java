package com.example.aryparamartha.printit.profile;

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

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.LoginActivity;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.model.Profile;

public class ProfileFragment extends Fragment implements View.OnClickListener, ProfileView {

    EditText nama_user, hp_user, alamat_user;
    Button logout, saveProfile;
    private ProfilePresenter presenter;
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

        presenter = new ProfilePresenter(this,ApiClient.getService(getContext()));
        presenter.showProfile();

        logout.setOnClickListener(this);
        saveProfile.setOnClickListener(this);

        preferencesHelper = new PreferencesHelper(getActivity());
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

    @Override
    public void onSuccess(Profile profile) {
        this.profile = profile;
        nama_user.setText(profile.getName());
        hp_user.setText(profile.getPhone());
        alamat_user.setText(profile.getAddress());
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
