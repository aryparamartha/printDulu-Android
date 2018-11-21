package com.example.aryparamartha.printit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aryparamartha.printit.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getListData();
    }

    public void getListData() {
//        UserDAO userDAO = new UserDAO(this);
//        final List<User> userList = userDAO.getAllData();
//
//        final ListView listView = (ListView) findViewById(R.id.list_view);
//
//        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, android.R.id.text1, userList);
//
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                int itemPosition = position;
//
//                User user = userList.get(position);
//            }
//        });

        //
    }
}
