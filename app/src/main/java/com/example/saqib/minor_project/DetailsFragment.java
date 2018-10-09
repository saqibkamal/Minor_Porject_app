package com.example.saqib.minor_project;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    DatabaseHelper myDB;
    ListView listView;
    View view;
    ImageView imageView;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_details, container, false);

        Bundle bundle = this.getArguments();
        String name = bundle.getString("name");

        Log.i("name",name);

        listView = (ListView) view.findViewById(R.id.listView);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        myDB = new DatabaseHelper(getContext());

        imageView.setImageResource(getResources().getIdentifier(name, "drawable", getActivity().getPackageName()));
        displayfunction(name);

        return view;
    }

    private void displayfunction(String name){
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents(name);
        if (data.getCount() == 0) {
            Toast.makeText(getContext(), "NOT FOUND", Toast.LENGTH_LONG).show();

        } else {
            int i=1;
            while (data.moveToNext() && i<8) {
                theList.add(data.getString(i));
                i++;
            }
            ListAdapter listAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, theList);
            listView.setAdapter(listAdapter);
        }
    }



}
