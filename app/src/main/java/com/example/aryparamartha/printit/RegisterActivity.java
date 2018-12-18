package com.example.aryparamartha.printit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.Api.ApiService;
import com.example.aryparamartha.printit.User.MainMenu.UserMainActivity;
import com.example.aryparamartha.printit.model.ResponseRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    protected EditText etRegisterName, etRegisterEmail, etRegisterPassword, etRegisterAddress, etRegisterPhone, etRegisterBank;
    protected Button btnRegister;
    protected TextView tvVendor;
    private ApiService service;
    private String adminStatus;
    private RadioGroup radioPrivilegeGroup;
    private RadioButton radioStoreButton, radioUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterName=findViewById(R.id.et_register_name);
        etRegisterEmail = findViewById(R.id.et_register_email);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etRegisterAddress = findViewById(R.id.et_register_address);
        etRegisterPhone = findViewById(R.id.et_register_phone);
        etRegisterBank = findViewById(R.id.et_register_rek);
        radioPrivilegeGroup = findViewById(R.id.radio_privilege_group);
        radioStoreButton = findViewById(R.id.radio_store);
        radioUserButton = findViewById(R.id.radio_user);

        radioStoreButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    etRegisterBank.setVisibility(View.VISIBLE);
                    radioUserButton.setChecked(false);
                    adminStatus = "1";
                }
            }
        });
        radioUserButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    etRegisterBank.setVisibility(View.GONE);
                    radioStoreButton.setChecked(false);
                    adminStatus = "0";
                }
            }
        });

        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
//        tvVendor.setOnClickListener(this);
        service = ApiClient.getService(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                service.register(etRegisterName.getText().toString(),
                        etRegisterEmail.getText().toString(),
                        etRegisterPhone.getText().toString(),
                        etRegisterAddress.getText().toString(),
                        etRegisterBank.getText().toString(),
                        etRegisterPassword.getText().toString(),
                        adminStatus).enqueue(new Callback<ResponseRegister>() {
                    @Override
                    public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                        startActivity(new Intent(RegisterActivity.this, UserMainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<ResponseRegister> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, ""+t, Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }
}
