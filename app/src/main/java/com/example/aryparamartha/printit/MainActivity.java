package com.example.aryparamartha.printit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.aryparamartha.printit.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

<<<<<<< HEAD
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();
        //getListData();
    }

//    public void getListData() {
////        UserDAO userDAO = new UserDAO(this);
////        final List<User> userList = userDAO.getAllData();
////
////        final ListView listView = (ListView) findViewById(R.id.list_view);
////
////        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, android.R.id.text1, userList);
////
////        listView.setAdapter(adapter);
////
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
////                int itemPosition = position;
////
////                User user = userList.get(position);
////            }
////        });
//
//        //
//    }
=======
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new UserHomeFragment()).commit();
    }

>>>>>>> db7525bfc631a7ceb252419d25bc8c6a770c20c4
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new UserHomeFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.nav_location:
                    selectedFragment = new UserLocationFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;
        }
    };
}
