package com.example.aryparamartha.printit.User.MainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;

public class AddTransUser extends AppCompatActivity {

    TextView namaFile, locFile, formatPrint;
    Button uploadFile, saveTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trans);

        namaFile = findViewById(R.id.namaFile);
        locFile = findViewById(R.id.filePath);
        formatPrint = findViewById(R.id.printFormat);
        uploadFile = findViewById(R.id.buttonOpenFile);
        saveTrans = findViewById(R.id.createTrans);
    }
}
