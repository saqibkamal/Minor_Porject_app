package com.example.saqib.minor_project;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button call,email;
    View view;
    ImageView imageView;
    ArrayList<String> theList;
    String number,email_address;


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

        call = (Button) view.findViewById(R.id.call);
        email = (Button) view.findViewById(R.id.email);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String te= theList.get(6);
                String tee[]=te.split(",",-1);
                number = tee[0];

                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                        "tel", number, null));
                startActivity(phoneIntent);


            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String te= theList.get(5);
                String tee[]=te.split(",",-1);
                email_address = tee[0];

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", email_address, null));

                getContext().startActivity(Intent.createChooser(emailIntent, null));
            }
        });


        imageView.setImageResource(getResources().getIdentifier(name, "drawable", getActivity().getPackageName()));
        displayfunction(name);

        return view;
    }

    private void displayfunction(String name){
        theList = new ArrayList<>();
        Cursor data = myDB.getListContents(name);
        if (data.getCount() == 0) {
            Toast.makeText(getContext(), "NOT FOUND", Toast.LENGTH_LONG).show();

        } else {
            int i=1;
            while (data.moveToNext() && i<8) {
                theList.add(data.getString(i));
                i++;
            }
            ListAdapter listAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, theList){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    // Cast the list view each item as text view
                    TextView item = (TextView) super.getView(position,convertView,parent);

                    item.setTextColor(Color.WHITE);

                    Typeface mtypeface = ResourcesCompat.getFont(getContext(), R.font.pt);
                    // Set the typeface/font for the current item
                    item.setTypeface(mtypeface,Typeface.BOLD);





                    return item;
                }
            };
            listView.setAdapter(listAdapter);

        }
    }



}
