package com.example.aryparamartha.printit.profile;

import android.util.Log;

import com.example.aryparamartha.printit.Api.ApiService;
import com.example.aryparamartha.printit.model.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    private ProfileView view;
    private ApiService service;

    public ProfilePresenter(ProfileView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void showProfile() {
        service.profile()
                .enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        if (response.isSuccessful()) {
                            Log.e("log", "tes");
                            view.onSuccess(response.body());
                        } else {
                            Log.e("log", "gagal");

                            view.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        view.onFailure(t);
                    }
                });
    }


}
