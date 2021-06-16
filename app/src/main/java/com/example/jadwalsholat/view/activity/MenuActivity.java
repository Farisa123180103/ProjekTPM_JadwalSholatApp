package com.example.jadwalsholat.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.jadwalsholat.view.fragmen.AlarmFragment;
import com.example.jadwalsholat.view.fragmen.JadwalFragment;
import com.example.jadwalsholat.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment = new JadwalFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.menu_utama_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_buttomnav_sholat:
                selectedFragment = new JadwalFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_buttomnav_alarm:
                selectedFragment = new AlarmFragment();
                loadFragment(selectedFragment);
                break;




        }
        return loadFragment(selectedFragment);
    }


    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer,selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
