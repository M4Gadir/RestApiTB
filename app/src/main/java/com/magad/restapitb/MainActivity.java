package com.magad.restapitb;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.magad.restapitb.fragment.FragmentTeam;
import com.magad.restapitb.fragment.FragmentVersus;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navigational);
        fm.beginTransaction().add(R.id.wadah,new FragmentTeam()).addToBackStack("").commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_team:
                       fm.beginTransaction().replace(R.id.wadah,new FragmentTeam()).addToBackStack("").commit();
                        return true;
                    case R.id.navigation_versus:
                        fm.beginTransaction().replace(R.id.wadah,new FragmentVersus()).addToBackStack("").commit();
                        return true;
                }
                return false;
            }
        });
    }
}
