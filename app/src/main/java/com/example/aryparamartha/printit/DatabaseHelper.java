package com.example.aryparamartha.printit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aryparamartha.printit.model.UserTrans;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "printdulu.db";
    private static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME = "tb_user";
    /*public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "email";
    public static final String COL_4 = "phone";
    public static final String COL_5 = "status";*/

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table "+ TABLE_NAME +" (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "name TEXT, " +
//                "email TEXT, " +
//                "phone TEXT, " +
//                "status BOOLEAN )" );

        String CREATE_TABLE_TRANS="CREATE TABLE "+UserTrans.Entry.TABLE_NAME+" ( "+
                UserTrans.Entry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                UserTrans.Entry.COLUMN_CREATED+" TEXT,"+
                UserTrans.Entry.COLUMN_FORMAT+" TEXT,"+
                UserTrans.Entry.COLUMN_IDTRANS+" INTEGER,"+
                UserTrans.Entry.COLUMN_LOCATION+" TEXT,"+
                UserTrans.Entry.COLUMN_NAME+" TEXT,"+
                UserTrans.Entry.COLUMN_TRANS+" INT,"+
                UserTrans.Entry.COLUMN_TRANSFILE+" TEXT,"+
                UserTrans.Entry.COLUMN_TRANSTOTAL+" INT,"+
                UserTrans.Entry.COLUMN_UPDATED+" TEXT,"+
                UserTrans.Entry.COLUMN_USER+" INTEGER );";

        db.execSQL(CREATE_TABLE_TRANS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("drop table if exists " +TABLE_NAME);
        String DROP_TABLE_USER = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

        db.execSQL(DROP_TABLE_USER);
        onCreate(db);
    }

    public long insertTransaction(String created, String format, int idtrans, String location, String name,
                                  int trans, String transfile, int transtotal, String updated, int user){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserTrans.Entry.COLUMN_CREATED, created);
        contentValues.put(UserTrans.Entry.COLUMN_FORMAT, format);
        contentValues.put(UserTrans.Entry.COLUMN_IDTRANS, idtrans);
        contentValues.put(UserTrans.Entry.COLUMN_LOCATION, location);
        contentValues.put(UserTrans.Entry.COLUMN_NAME, name);
        contentValues.put(UserTrans.Entry.COLUMN_TRANS, trans);
        contentValues.put(UserTrans.Entry.COLUMN_TRANSFILE, transfile);
        contentValues.put(UserTrans.Entry.COLUMN_TRANSTOTAL, transtotal);
        contentValues.put(UserTrans.Entry.COLUMN_UPDATED, updated);
        contentValues.put(UserTrans.Entry.COLUMN_USER, user);

        long lastId = sqLiteDatabase.insert(UserTrans.Entry.TABLE_NAME,null, contentValues);

        return lastId;
    }

    public void deleteTransaction(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(UserTrans.Entry.TABLE_NAME, null, null);
    }

    public List<UserTrans> selectTrans(){
        List<UserTrans> userTrans = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(UserTrans.Entry.TABLE_NAME,null
                ,null,null,null,null,null);

        if (cursor !=null){
            cursor.moveToFirst();
            do {
                String created = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_CREATED));
                String format = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_FORMAT));
                int idtrans = cursor.getInt(cursor.getColumnIndex(UserTrans.Entry.COLUMN_IDTRANS));
                String location = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_LOCATION));
                String name = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_NAME));
                int trans = cursor.getInt(cursor.getColumnIndex(UserTrans.Entry.COLUMN_TRANS));
                String transfile = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_TRANSFILE));
                int transtotal = cursor.getInt(cursor.getColumnIndex(UserTrans.Entry.COLUMN_TRANSTOTAL));
                String updated = cursor.getString(cursor.getColumnIndex(UserTrans.Entry.COLUMN_UPDATED));
                int user = cursor.getInt(cursor.getColumnIndex(UserTrans.Entry.COLUMN_USER));

                UserTrans tmp=new UserTrans(created, format, idtrans, location, name, trans, transfile, transtotal, updated, user);

                userTrans.add(tmp);
            }while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();

        return userTrans;
    }
}
