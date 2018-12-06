package com.example.aryparamartha.printit.Vendor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.aryparamartha.printit.R;

public class VendorMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.admin_bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().add(R.id.admin_fragment_container,new VendorHomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.admin_nav_home:
                    selectedFragment = new VendorHomeFragment();
                    break;
                case R.id.admin_nav_profile:
                    selectedFragment = new VendorProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.admin_fragment_container,selectedFragment).commit();
            return true;
        }
    };
}
