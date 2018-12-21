package com.example.aryparamartha.printit.Vendor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.Vendor.MainMenu.VendorHomeFragment;
import com.example.aryparamartha.printit.Vendor.Profile.VendorProfileFragment;
import com.example.aryparamartha.printit.model.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VendorMainActivity extends AppCompatActivity {
    private PreferencesHelper preferencesHelper;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.admin_bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().add(R.id.admin_fragment_container,new VendorHomeFragment()).commit();

        preferencesHelper = new PreferencesHelper(this);
        Log.d("fcm", preferencesHelper.getFCMToken());
        
        showProfile();
    }

    private void showProfile() {
        ApiClient.getService(this)
                .profile()
                .enqueue(new Callback<Profile>() {
                    @Override
                    public void onResponse(Call<Profile> call, Response<Profile> response) {
                        if (response.isSuccessful()){
                            profile = response.body();
                            if (profile.getFcmToken()==null){
                                saveFCMToken(profile.getId(), preferencesHelper.getFCMToken());
                            }
                        }else {
                            Toast.makeText(VendorMainActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Profile> call, Throwable t) {
                        Toast.makeText(VendorMainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveFCMToken(int id, String fcmToken) {
        ApiClient.getService(this)
                .saveFCM(id, fcmToken)
                .enqueue(new Callback<com.example.aryparamartha.printit.model.Response>() {
                    @Override
                    public void onResponse(Call<com.example.aryparamartha.printit.model.Response> call, Response<com.example.aryparamartha.printit.model.Response> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(VendorMainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(VendorMainActivity.this, "Response Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<com.example.aryparamartha.printit.model.Response> call, Throwable t) {
                        Toast.makeText(VendorMainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.admin_nav_home:
                    selectedFragment = new VendorHomeFragment();
                    break;
                case R.id.admin_nav_profile:
                    selectedFragment = new VendorProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container,selectedFragment).commit();
            return true;
        }
    };
}
