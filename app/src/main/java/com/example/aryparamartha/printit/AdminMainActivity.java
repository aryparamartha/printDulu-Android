package com.example.aryparamartha.printit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_admin);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.admin_bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.admin_nav_home,new AdminHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.admin_nav_home:
                    selectedFragment = new AdminHomeFragment();
                    break;
                case R.id.admin_nav_profile:
                    selectedFragment = new AdminProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container,selectedFragment).commit();
            return true;
        }
    };
}
