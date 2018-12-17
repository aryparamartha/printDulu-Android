package com.example.aryparamartha.printit.Vendor.MainMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.aryparamartha.printit.R;
import com.example.aryparamartha.printit.model.UserTrans;
import com.example.aryparamartha.printit.model.VendorTrans;

public class VendorDetailFileActivity extends AppCompatActivity {

    TextView namaFile, locFile, hargaFile, buktiPembayaran, formatPrint;
    Button uploadFile, uploadBukti, saveTrans;
    VendorTrans vendorTrans;
    public static final String KEY_FILE = "vendorTrans";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_file_vendor);
        init();
        setView();
    }

    private void setView() {
        namaFile.setText(vendorTrans.getNamaFile());
        locFile.setText(vendorTrans.getFileLocation());
        hargaFile.setText(String.valueOf(vendorTrans.getTransTotal()));
        buktiPembayaran.setText(vendorTrans.getTransFile());
        formatPrint.setText(vendorTrans.getFormatFile());
    }

    private void init() {
        vendorTrans = getIntent().getParcelableExtra(KEY_FILE);

        namaFile = findViewById(R.id.tvNamaFile);
        locFile = findViewById(R.id.tvFileLoc);
        hargaFile = findViewById(R.id.harga);
        buktiPembayaran = findViewById(R.id.tvBuktiPath);
        formatPrint = findViewById(R.id.tvDetailPrint);

        uploadFile = findViewById(R.id.buttonDownloadBukti);
        uploadBukti = findViewById(R.id.buttonDownloadBukti);
        saveTrans = findViewById(R.id.validate);

    }
}
