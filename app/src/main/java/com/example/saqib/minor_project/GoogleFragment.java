package com.example.saqib.minor_project;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoogleFragment extends Fragment {

    ImageView imageView;
    TextView nameView,designationView;
    View view;
    static WebView webView;
    DatabaseHelper myDB;
    String name,fullname,designation;
    Bundle webViewBundle;


    public GoogleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_google, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView2);
        nameView = (TextView) view.findViewById(R.id.txtName);
        designationView = (TextView) view.findViewById(R.id.txtDesignation);
        webView = (WebView) view.findViewById(R.id.webView);
        myDB = new DatabaseHelper(getContext());

        Bundle bundle = this.getArguments();
        name = bundle.getString("name");

        imageView.setImageResource(getResources().getIdentifier(name, "drawable", getActivity().getPackageName()));


        getNameDes();

        loadWebView();

        return view;
    }

    private void getNameDes(){

        Cursor data = myDB.getListContents(name);
        if (data.getCount() == 0) {
            Toast.makeText(getContext(), "NOT FOUND", Toast.LENGTH_LONG).show();

        } else {

            data.moveToNext();
            fullname = data.getString(1);
            designation =data.getString(2);

            nameView.setText(fullname);
            designationView.setText(designation);
        }
    }

    private void loadWebView(){
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());

        if (webViewBundle == null) {
            webView.loadUrl("https://www.google.com/search?q="+fullname+" NIT Kurukshetra");
        } else {
            webView.restoreState(webViewBundle);
        }

    }

    public static boolean canGoBack(){
        return webView.canGoBack();
    }

    public static void goBack(){
        webView.goBack();
    }

    @Override
    public void onPause() {
        super.onPause();

        webViewBundle = new Bundle();
        webView.saveState(webViewBundle);
    }



}
