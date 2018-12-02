package com.example.aryparamartha.printit.profile;

import com.example.aryparamartha.printit.model.Profile;

public interface ProfileView {
    void onSuccess(Profile profile);
    void onError();
    void onFailure(Throwable t);
}
