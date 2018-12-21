package com.example.aryparamartha.printit.User.MainMenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.Api.ApiService;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.Utils.PreferencesHelper;
import com.example.aryparamartha.printit.model.ResponseCreateTrans;
import com.example.aryparamartha.printit.model.User;
import com.example.aryparamartha.printit.model.UserTrans;
import com.example.aryparamartha.printit.model.UserVendor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateTransActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText etFileName, etFileLink, etPrintFormat;
    protected Button btnCreateTrans;
    protected ApiService service;
    private PreferencesHelper prefHelp;
    public String idUser;
    public String idVendor;
    public String idStatus;
    UserVendor userVendor;
    String namaVendor;
    TextView vendorName;
    public static final String KEY_FILE = "userVendor";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trans);

        Intent intent = getIntent();
        idVendor = String.valueOf(intent.getIntExtra("idUser",0));
        namaVendor = intent.getStringExtra("name");

        prefHelp = new PreferencesHelper(this);
        idUser = String.valueOf(prefHelp.getID());
//        idVendor = String.valueOf(userVendor.getId());
        
        service = ApiClient.getService(this);


        etFileName = findViewById(R.id.namaFile);
        etFileLink = findViewById(R.id.fileLink);
        etPrintFormat = findViewById(R.id.printFormat);
        btnCreateTrans = findViewById(R.id.createTrans);

        btnCreateTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "kontol", Toast.LENGTH_SHORT).show();
                service.createTrans(idUser, idVendor, etFileName.getText().toString(),etFileLink.getText().toString(), etPrintFormat.getText().toString())
                        .enqueue(new Callback<ResponseCreateTrans>() {
                            @Override
                            public void onResponse(Call<ResponseCreateTrans> call, Response<ResponseCreateTrans> response) {
                                Intent intent = new Intent(CreateTransActivity.this, UserMainActivity.class);
                                Toast.makeText(CreateTransActivity.this, "Transaksi Berhasil di Simpan", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<ResponseCreateTrans> call, Throwable t) {
                                Toast.makeText(CreateTransActivity.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        idStatus = "0";

        init();
        setView();
        

    }

    private void setView() {
        vendorName.setText(namaVendor);
    }

    private void init() {
        userVendor = getIntent().getParcelableExtra(KEY_FILE);
        vendorName = findViewById(R.id.namaVendor);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createTrans:
                Toast.makeText(this, "kontol", Toast.LENGTH_SHORT).show();
                service.createTrans(idUser, idVendor, etFileName.getText().toString(),etFileLink.getText().toString(), etPrintFormat.getText().toString())
                        .enqueue(new Callback<ResponseCreateTrans>() {
                            @Override
                            public void onResponse(Call<ResponseCreateTrans> call, Response<ResponseCreateTrans> response) {
                                UserHomeFragment fragment = new UserHomeFragment();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.fragment_container, fragment);
                                transaction.commit();

                                Toast.makeText(CreateTransActivity.this, "Transaksi Berhasil di Simpan", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<ResponseCreateTrans> call, Throwable t) {
                                Toast.makeText(CreateTransActivity.this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                            }
                        });
        }
    }

}

