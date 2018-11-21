package com.example.aryparamartha.printit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity{

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userDAO = new UserDAO(this);

        ((Button) findViewById(R.id.button_save)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name = ((TextView) findViewById(R.id.edit_name)).getText().toString();
                String email = ((TextView) findViewById(R.id.edit_email)).getText().toString();
                String phone = ((TextView) findViewById(R.id.edit_phone)).getText().toString();
            }
        });
    }
}
