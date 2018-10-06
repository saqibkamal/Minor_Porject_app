package com.example.saqib.minor_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Persons_List extends AppCompatActivity {

    String[] names,fullnames;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons__list);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        names = (String[]) args.getSerializable("NAMELIST");
        fullnames= (String[]) args.getSerializable("FULLNAME");

        listView=findViewById(R.id.list_view);

        listView.setAdapter(new display_adapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), Personal_Detail.class);
                i.putExtra("name", names[position]);
                startActivity(i);
            }
        });

    }


    public class display_adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_list_layout, null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
            TextView textView1 = (TextView) convertView.findViewById(R.id.txtName);
            TextView textView2 = (TextView) convertView.findViewById(R.id.txtPrice);

            textView1.setText(fullnames[position]);
            textView2.setText(names[position]);
            imageView.setImageResource(getResources().getIdentifier(names[position], "drawable", getPackageName()));



            return convertView;
        }
    }
}
