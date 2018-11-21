package com.example.aryparamartha.printit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aryparamartha.printit.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private DatabaseHelper dbHelper;
    private String TABLE_NAME = dbHelper.TABLE_NAME;

    public UserDAO(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public boolean checkDB(){
        if (dbHelper.getWritableDatabase()==null){
            return false;
        } else {
            return true;
        }
    }

    //inserting user
    public long insert(User user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, user.getName());
        contentValues.put(DatabaseHelper.COL_3, user.getEmail());
        contentValues.put(DatabaseHelper.COL_4, user.getPhone());
        contentValues.put(DatabaseHelper.COL_5, user.getAdminStatus());
        long id = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        return id;
    }

    //update user info
    public int update(User user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, user.getName());
        contentValues.put(DatabaseHelper.COL_3, user.getEmail());
        contentValues.put(DatabaseHelper.COL_4, user.getPhone());
        contentValues.put(DatabaseHelper.COL_5, user.getAdminStatus());

        return db.update(
                DatabaseHelper.TABLE_NAME,
                contentValues,
                DatabaseHelper.COL_1+" = ?",
                new String[]{
                        String.valueOf(user.getId())
                }
        );
    }

    //delete user
    public int delete(User user){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(
                DatabaseHelper.TABLE_NAME,
                DatabaseHelper.COL_1+" = ?",
                new String[]{
                        String.valueOf(user.getId())
                }
        );
    }

//    public List<User> getAllData(){
//        String sql = "select * from "+ DatabaseHelper.TABLE_NAME;
//        return executeQuery(sql);
//    }

//    private List<User> executeQuery(String sql) {
//        List<User> userList = new ArrayList<User>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor res = db.rawQuery(sql, null);
//        res.moveToFirst();

//        while (res.isAfterLast()==false){
//            userList.add(
//                    new User(
//                            res.getString(res.getColumnIndex(DatabaseHelper.COL_4)),
//                            res.getString(res.getColumnIndex(DatabaseHelper.COL_2)),
//                            res.getInt(res.getColumnIndex(DatabaseHelper.COL_5)),
//                            res.getInt(res.getColumnIndex(DatabaseHelper.COL_1)),
//                            res.getString(res.getColumnIndex(DatabaseHelper.COL_3))
//                    )
//            );
//            res.moveToNext();
//        }
//        return userList;
//    }


}
