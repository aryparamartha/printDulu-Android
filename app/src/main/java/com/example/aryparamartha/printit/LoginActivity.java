package com.example.aryparamartha.printit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.Api.ApiService;
import com.example.aryparamartha.printit.User.MainMenu.UserMainActivity;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.Vendor.VendorMainActivity;
import com.example.aryparamartha.printit.model.UserLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button btnLogin;
    protected TextView tvRegister;
    protected EditText etEmail, etPassword;
    private ApiService service;
    private PreferencesHelper preferencesHelper;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin=findViewById(R.id.btn_login);
        tvRegister=findViewById(R.id.tv_register);
        etEmail=findViewById(R.id.et_email);
        etPassword=findViewById(R.id.et_password);

        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        if(sharedPref.contains("token")){
           Intent intent = new Intent(this, UserMainActivity.class);
           startActivity(intent);
           finish();
        }else{
            Toast.makeText(this,"tes",Toast.LENGTH_LONG).show();
        }

        preferencesHelper = new PreferencesHelper(  this);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        service= ApiClient.getService(this);

//        preferencesHelper = new PreferencesHelper(this);
    }

//    public void saveInfo(Login login){
//        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("email", etEmail.getText().toString());
//        editor.putString("password", etPassword.getText().toString());
//        editor.putString("token", login.getSuccess().getToken());
//        editor.apply();
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                service.login(etEmail.getText().toString(), etPassword.getText().toString()).enqueue(new Callback<UserLogin>() {
                    @Override
                    public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                        if(response.isSuccessful()) {
                            UserLogin responseLogin = response.body();
                            preferencesHelper.setUserLogin(responseLogin);
//                            user = responseLogin.getAdminStatus();
                            if(responseLogin.getAdminStatus().equals("1")){
                                startActivity(new Intent(LoginActivity.this, VendorMainActivity.class));
                            } else {
                                startActivity(new Intent(LoginActivity.this, UserMainActivity.class));
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, "ahhaha"+response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<UserLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "failure"+t, Toast.LENGTH_SHORT).show();
                    }
                });
//                startActivity(new Intent(LoginActivity.this, UserMainActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}
