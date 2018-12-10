package com.example.aryparamartha.printit.User.MainMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserTrans;

public class DetailFileActivity extends AppCompatActivity {

    TextView namaFile, locFile, hargaFile, buktiPembayaran, formatPrint;
    Button uploadFile, uploadBukti, saveTrans;
    UserTrans userTrans;
    public static final String KEY_FILE = "userTrans";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_trans);

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

        namaFile = findViewById(R.id.file_name);
        locFile = findViewById(R.id.fileLoc);
        hargaFile = findViewById(R.id.filePath);
        buktiPembayaran = findViewById(R.id.buktiPath);
        formatPrint = findViewById(R.id.detailPrint);

        uploadFile = findViewById(R.id.buttonOpen);
        uploadBukti = findViewById(R.id.buttonUpload);
        saveTrans = findViewById(R.id.sendFile);

    }
}
