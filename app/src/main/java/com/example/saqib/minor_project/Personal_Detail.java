package com.example.saqib.minor_project;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Personal_Detail extends AppCompatActivity {

    DatabaseHelper myDB;
    ListView listView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal__detail);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");

        imageView=findViewById(R.id.imageView);
        listView = findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);

        imageView.setImageResource(getResources().getIdentifier(name, "drawable", getPackageName()));

        displayfunction(name);


    }

    private void displayfunction(String name){
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents(name);
        if (data.getCount() == 0) {
            Toast.makeText(Personal_Detail.this, "NOT FOUND", Toast.LENGTH_LONG).show();

        } else {
            int i=1;
            while (data.moveToNext() && i<8) {
                theList.add(data.getString(i));
                i++;
            }
            ListAdapter listAdapter = new ArrayAdapter<>(Personal_Detail.this, android.R.layout.simple_list_item_1, theList);
            listView.setAdapter(listAdapter);
        }
    }
}
