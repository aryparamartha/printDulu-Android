package com.example.aryparamartha.printit.User.MainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryparamartha.printit.Api.ApiClient;
import com.example.aryparamartha.printit.Api.ApiService;
import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserTrans;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailFileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView namaFile, locFile, hargaFile, buktiPembayaran, formatPrint;
    Button  saveTrans;
    UserTrans userTrans;
    public static final String KEY_FILE = "userTrans";
    int id_trans;
    ApiService service;
    public String id_status = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trans);
//        id_trans=userTrans.getIdTrans();
        init();
        setView();
    }

    private void setView() {
        namaFile.setText(userTrans.getNamaFile());
        locFile.setText(userTrans.getFileLocation());
        hargaFile.setText(String.valueOf(userTrans.getTransTotal()));
        buktiPembayaran.setText(userTrans.getTransFile());
        formatPrint.setText(userTrans.getFormatFile());
    }

    private void init() {
        userTrans = getIntent().getParcelableExtra(KEY_FILE);
        Log.e("ID_ANNJING", String.valueOf(userTrans.getIdTrans()));
        namaFile = findViewById(R.id.file_name);
        locFile = findViewById(R.id.filePath);
        hargaFile = findViewById(R.id.price);
        buktiPembayaran = findViewById(R.id.buktiPath);
        formatPrint = findViewById(R.id.detailPrint);

//        uploadFile = findViewById(R.id.buttonOpen);
//        uploadBukti = findViewById(R.id.buttonUpload);
        saveTrans = findViewById(R.id.sendFile);
        saveTrans.setOnClickListener(this);
        service=ApiClient.getService(this);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.sendFile:
                service.updateTrans(userTrans.getIdTrans(), String.valueOf(namaFile), String.valueOf(locFile), String.valueOf(formatPrint), String.valueOf(buktiPembayaran), String.valueOf(hargaFile), id_status)
                    .enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            Intent intent = new Intent(DetailFileActivity.this, UserMainActivity.class);
                            Toast.makeText(DetailFileActivity.this, "Transaksi Berhasil di ubah", Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            Toast.makeText(DetailFileActivity.this, "Gagal menyimpan", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
