package com.example.saqib.minor_project;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

import android.os.StrictMode;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.roger.catloadinglibrary.CatLoadingView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button camera,gallery,home;
    ImageView imageView;

    File imagefile;
    Uri imageUri;
    String name;

    DatabaseHelper myDB;
    ListView listView;

    CatLoadingView catLoadingView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.INTERNET
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();


        camera = (Button) findViewById(R.id.camera);
        imageView = (ImageView)  findViewById(R.id.imageView);
        gallery = (Button) findViewById(R.id.gallery);
        home = (Button) findViewById(R.id.home);

        camera.setOnClickListener(this);
        gallery.setOnClickListener(this);
        home.setOnClickListener(this);

        catLoadingView = new CatLoadingView();


        listView = (ListView) findViewById(R.id.listView);

        myDB = new DatabaseHelper(this);
        myDB.addData();


        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());



    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.camera){
            Random rand = new Random();

            int  n = rand.nextInt(500000) + 1;
            Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            imagefile = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES),"tesfsdft"+n+".jpg"
            );
            imageUri=Uri.fromFile(imagefile);

            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);

            startActivityForResult(intent,0);


        }
        else if(v.getId()==R.id.gallery){
            pickImage();
        }
        else if(v.getId()==R.id.home){
            return_home();
        }
    }


    public void pickImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            switch (resultCode){
                case Activity.RESULT_OK:
                    Log.i("File","Sucess"+imagefile.getAbsolutePath());
                    imageView.setImageURI(imageUri);

                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                        sendPhoto(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    break;
                default:
                    Log.i("File","Badly Failed");
            }
        }
        else if(requestCode==1){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                sendPhoto(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void displayfunction(String name){
        Log.i("Found name", name);
        myDB.getListContents(name);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents(name);
        if (data.getCount() == 0) {
            Log.i("Not","found");
            Toast.makeText(MainActivity.this, "NOT FOUND", Toast.LENGTH_LONG).show();
        } else {
            int i=1;
            while (data.moveToNext() && i<8) {
                theList.add(data.getString(i));
                i++;

            }

            Log.i("Table", theList.toString());

            ListAdapter listAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, theList);
            listView.setAdapter(listAdapter);
        }
    }

    private void sendPhoto(Bitmap bitmap) throws Exception {
        new UploadTask().execute(bitmap);
    }

    private class UploadTask extends AsyncTask<Bitmap, Void, Void> {



        protected Void doInBackground(Bitmap... bitmaps) {
            if (bitmaps[0] == null)
                return null;


            catLoadingView.setText("PROCESSING");
            catLoadingView.show(getSupportFragmentManager(),"");

           String ImageString=encodeImage(bitmaps[0]);


            JSONObject jsonObject=new JSONObject();
            try {
                jsonObject.put("image",ImageString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            DefaultHttpClient httpclient = new DefaultHttpClient();
            try {
                HttpPost httppost = new HttpPost(
                        "http://10.0.2.2:5000/predict"); // server

                StringEntity se;
                se = new StringEntity(jsonObject.toString());
                httppost.setEntity(se);

                httppost.setHeader("Content-type", "application/json");

                HttpResponse response = null;
                try {
                    response = httpclient.execute(httppost);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String result="";
                try {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            response.getEntity().getContent()));
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result = result + line;
                    }
                    Log.i("msgr", result);
                    name=result;
                    name = name.replace(" " , "");

                } catch (Exception e) {
                    result = "error2";
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } finally {

            }



            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            catLoadingView.dismiss();
            Log.i("OnPost","Execute");
            //image.setImageResource(getResources().getIdentifier(a.toLowerCase(), "drawable", getPackageName()));
            imageView.setImageResource(getResources().getIdentifier(name,"drawable",getPackageName()));
            displayfunction(name);

            //Toast.makeText(MainActivity.this, "Uploaded "+ name, Toast.LENGTH_LONG).show();
        }
    }

    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
    public String encodeImage(Bitmap imageByteArray) {
        return android.util.Base64.encodeToString(getBytesFromBitmap(imageByteArray),
                android.util.Base64.NO_WRAP);
    }

    private void return_home(){
        ArrayList<String> theList = new ArrayList<>();
        ListAdapter listAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, theList);
        listView.setAdapter(listAdapter);
        imageView.setImageResource(0);
    }

}
