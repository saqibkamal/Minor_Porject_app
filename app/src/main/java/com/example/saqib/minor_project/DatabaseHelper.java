package com.example.saqib.minor_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Informations.db";
    public static final String TABLE_NAME = "Information";
    public static final String colid = "id";
    public static final String colname = "name";
    public static final String coldesignation = "designation";
    public static final String coldepartment = "department";
    public static final String colqualification = "qualification";
    public static final String coladdress = "address";
    public static final String colemail= "email";
    public static final String colcontact = "contact";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("+colid+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ colname + " VARCHAR, "
                + coldesignation + " VARCHAR, " + coldepartment + " VARCHAR, "+ colqualification + " VARCHAR, " + coladdress + " VARCHAR, "+ colemail + " VARCHAR, " + colcontact + " VARCHAR )";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        ContentValues cv1 = new ContentValues();
        cv1.put(colname,"Sonu Kumar Chaudhary");
        cv1.put(coldesignation,"Student");
        cv1.put(coldepartment,"Computer engineering");
        cv1.put(colqualification,"B.Tech");
        cv1.put(coladdress,"Jaleshwar-11, Mahottari, Nepal");
        cv1.put(colemail,"csonu020@gmail.com");
        cv1.put(colcontact,"8683923389");
        db.insert(TABLE_NAME, null, cv1);

        ContentValues cv2 = new ContentValues();
        cv2.put(colname,"Saqib Kamal");
        cv2.put(coldesignation,"Student");
        cv2.put(coldepartment,"Computer engineering");
        cv2.put(colqualification,"B.Tech");
        cv2.put(coladdress,"Biratnagar, Nepal");
        cv2.put(colemail,"saqib.kama01@gmail.com");
        cv2.put(colcontact,"8059710704");
        db.insert(TABLE_NAME, null, cv2);

        ContentValues cv3 = new ContentValues();
        cv3.put(colname,"sachin");
        cv3.put(coldesignation,"Student");
        cv3.put(coldepartment,"Computer engineering");
        cv3.put(colqualification,"B.Tech");
        cv3.put(coladdress,"Rajbiraj, Nepal");
        cv3.put(colemail,"jhasachin213@gmail.com");
        cv3.put(colcontact,"9896639877");
        db.insert(TABLE_NAME, null, cv3);

        ContentValues cv4 = new ContentValues();
        cv4.put(colname,"Dr.Mantosh Biswas");
        cv4.put(coldesignation,"Assistant Professor");
        cv4.put(coldepartment,"Computer engineer");
        cv4.put(colqualification,"Ph.D (ISM Dhanbad)");
        cv4.put(coladdress,"Room No-209 Computer Dept.");
        cv4.put(colemail,"mantoshb@gmail.com");
        cv4.put(colcontact,"01744-233489");
        db.insert(TABLE_NAME, null, cv4);

        ContentValues cv5 = new ContentValues();
        cv5.put(colname,"Bharati Sinha");
        cv5.put(coldesignation,"Assistant Professor");
        cv5.put(coldepartment,"Computer engineering");
        cv5.put(colqualification,"Ph.D (Pursuing)");
        cv5.put(coladdress,"Room No-209 Computer Dept.");
        cv5.put(colemail,"bharatisinha@nitkkr.ac.in");
        cv5.put(colcontact,"N/A");
        db.insert(TABLE_NAME, null, cv5);

        db.setTransactionSuccessful();
        db.endTransaction();

        db.close();

    }
    public Cursor getListContents(String names){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE name LIKE '%"+names+"%'",null);
        return data;
    }
}
