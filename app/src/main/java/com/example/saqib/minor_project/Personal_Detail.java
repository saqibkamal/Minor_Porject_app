package com.example.saqib.minor_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Personal_Detail extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    DetailsFragment detailsFragment;
    GoogleFragment googleFragment;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__detail);

        Intent intent = getIntent();
        name = intent.getExtras().getString("name");

        bottomNavigationView = findViewById(R.id.bottomView);


        detailsFragment = new DetailsFragment();
        googleFragment = new GoogleFragment();


        setFragment(detailsFragment);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.detail:
                        setFragment(detailsFragment);
                        return true;

                    case R.id.google:
                        setFragment(googleFragment);
                        return true;

                        default:
                            return false;

                }

            }
        });




    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("name",name );
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.Frame,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        if(GoogleFragment.canGoBack()){
            GoogleFragment.goBack();
        }else{
            super.onBackPressed();
        }

    }


}
