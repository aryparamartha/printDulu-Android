package com.example.aryparamartha.printit.User;

import android.content.Intent;
<<<<<<< HEAD
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
=======
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
>>>>>>> 2f87070c1a5c28746f649804d36066b238a75397

import com.example.aryparamartha.printit.LoginActivity;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.User.MainMenu.UserMainActivity;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.Vendor.VendorMainActivity;

public class SplashScreen extends AppCompatActivity {
    private static int splash_time_out = 2000;
    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        preferencesHelper = new PreferencesHelper(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (preferencesHelper.getLogin()){
                    if (preferencesHelper.getUserType()==0){
                        intent = new Intent(SplashScreen.this,UserMainActivity.class);
                    }else {
                        intent = new Intent(SplashScreen.this, VendorMainActivity.class);
                    }
                }else {
                    intent = new Intent(SplashScreen.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, splash_time_out);
    }
}
