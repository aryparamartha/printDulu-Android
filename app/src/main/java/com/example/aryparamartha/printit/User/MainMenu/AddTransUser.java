package com.example.aryparamartha.printit.User.MainMenu;

import android.Manifest;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryparamartha.printit.R;

import java.util.regex.Pattern;

public class AddTransUser extends AppCompatActivity {

    TextView namaFile, locFile, formatPrint;
    Button uploadFile, saveTrans;
    Uri PdfUri;
    static final int CODE_PDF = 200;
    int startType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_trans);

        namaFile = findViewById(R.id.namaFile);
        locFile = findViewById(R.id.filePath);
        formatPrint = findViewById(R.id.printFormat);
        uploadFile = findViewById(R.id.buttonOpenFile);
        saveTrans = findViewById(R.id.createTrans);

        uploadFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startType = CODE_PDF;
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    Toast.makeText(AddTransUser.this, "keteken kontol", Toast.LENGTH_SHORT).show();
                    if(checkStoragePermission()){
                        startPDF();
                    } else {
                        startPDF();
                    }
                } else {
                    Toast.makeText(AddTransUser.this, "gagal kebuka tapi mau keteken", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;
    private boolean checkStoragePermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_STORAGE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_STORAGE);
            }
            return false;
        } else {
            return true;
        }
    }


    public void startPDF(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        startActivityForResult(Intent.createChooser(intent, "Select PDF"), CODE_PDF);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_PDF && resultCode == RESULT_OK && data != null && data.getData() != null){
            PdfUri = data.getData();
            if (!data.equals("")){
                locFile.setText(PdfUri.getPath());

                String filePath = getRealPathFromURI_API19(this, PdfUri);
            }
        }
    }

    public static String getRealPathFromURI_API19(final Context context, final Uri uri){

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;

        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)){
            if (isExternalStorageDocument(uri)){
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)){
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)){
                Cursor cursor = null;

                try {
                    String[] s={MediaStore.MediaColumns.DISPLAY_NAME};
                    cursor = context.getContentResolver().query(uri,s,null,null,null);
                    String fileName = cursor.getString(0);
                    String path = Environment.getExternalStorageDirectory().toString()+"/Download/"+fileName;
                    if (!TextUtils.isEmpty(path)){
                        return path;
                    }
                } finally {
                    cursor.close();
                }

                String id = DocumentsContract.getDocumentId(uri);
                if (id.startsWith("raw:")){
                    return id.replaceFirst(Pattern.quote("raw:"), "");
                }

                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())){
            return uri.getPath();
        }

        return null;
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()){
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null){
                cursor.close();
            }
        } return null;
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
