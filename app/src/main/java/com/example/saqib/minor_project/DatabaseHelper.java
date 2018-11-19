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
        cv3.put(colname,"Sachin Jha");
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

        ContentValues cv6 = new ContentValues();
        cv6.put(colname,"Rajesh Kumar Aggarwal");
        cv6.put(coldesignation,"Associate Professor");
        cv6.put(coldepartment,"Computer engineering");
        cv6.put(colqualification,"PhD(NIT Kurukshetra), 2014");
        cv6.put(coladdress,"N/A");
        cv6.put(colemail,"rka15969@gmail.com");
        cv6.put(colcontact,"01744-233483,01744-233259,01744-233479");
        db.insert(TABLE_NAME, null, cv6);

        ContentValues cv7 = new ContentValues();
        cv7.put(colname,"Mayank Dave");
        cv7.put(coldesignation,"Professor");
        cv7.put(coldepartment,"Computer engineering");
        cv7.put(colqualification,"Ph.D (2002, IIT Roorkee), Senior Member IEEE");
        cv7.put(coladdress,"N/A");
        cv7.put(colemail,"mdave@nitkkr.ac.in m.dave@ieee.org");
        cv7.put(colcontact,"01744-233480");
        db.insert(TABLE_NAME, null, cv7);


        ContentValues cv8 = new ContentValues();
        cv8.put(colname,"Jitender Kumar Chhabra");
        cv8.put(coldesignation,"Professor");
        cv8.put(coldepartment,"Computer engineering");
        cv8.put(colqualification,"B.Tech(CSE) from NITK as 2nd Topper, M.Tech (CSE) from NITK as Gold Medalist, PhD (S/w Engg)");
        cv8.put(coladdress,"N/A");
        cv8.put(colemail,"jitenderchhabra@nitkkr.ac.in");
        cv8.put(colcontact,"+91-1744-233482");
        db.insert(TABLE_NAME, null, cv8);

        ContentValues cv9 = new ContentValues();
        cv9.put(colname,"Awadhesh Kumar Singh");
        cv9.put(coldesignation,"Professor");
        cv9.put(coldepartment,"Computer engineering");
        cv9.put(colqualification,"PhD (Engineering), Jadavpur University Kolkata, Year 2004");
        cv9.put(coladdress,"N/A");
        cv9.put(colemail,"aksingh@nitkkr.ac.in");
        cv9.put(colcontact,"01744-233481,09416570992");
        db.insert(TABLE_NAME, null, cv9);

        ContentValues cv10 = new ContentValues();
        cv10.put(colname,"Sanjay Kumar Jain");
        cv10.put(coldesignation,"Professor");
        cv10.put(coldepartment,"Computer engineering");
        cv10.put(colqualification,"PhD 2006 MNNIT, Allahabad");
        cv10.put(coladdress,"N/A");
        cv10.put(colemail,"skj_nith@yahoo.com");
        cv10.put(colcontact,"01744-233490");
        db.insert(TABLE_NAME, null, cv10);


        ContentValues cv11 = new ContentValues();
        cv11.put(colname,"Rajeev Mohan Sharma");
        cv11.put(coldesignation,"Associate Professor");
        cv11.put(coldepartment,"Computer engineering");
        cv11.put(colqualification,"PhD (Specialisation in Computer Networks) 2014 KuK, M.Tech.(Computer Engg) 1998 , B.Tech(HBTI Kanpur))");
        cv11.put(coladdress,"N/A");
        cv11.put(colemail,"rmsharma123@rediffmail.com");
        cv11.put(colcontact,"01744-233484");
        db.insert(TABLE_NAME, null, cv11);


        ContentValues cv12 = new ContentValues();
        cv12.put(colname,"Priyanka Ahlawat");
        cv12.put(coldesignation,"Assistant Professor");
        cv12.put(coldepartment,"Computer engineering");
        cv12.put(colqualification,"PhD(Pursuing) NIT Kurukshetra");
        cv12.put(coladdress,"N/A");
        cv12.put(colemail,"priyankaahlawat@nitkkr.ac.in");
        cv12.put(colcontact,"01744-233493");
        db.insert(TABLE_NAME, null, cv12);

        ContentValues cv13 = new ContentValues();
        cv13.put(colname,"Mohit Dua");
        cv13.put(coldesignation,"Assistant Professor");
        cv13.put(coldepartment,"Computer engineering");
        cv13.put(colqualification,"PhD(Pursuing) NIT Kurukshetra");
        cv13.put(coladdress,"N/A");
        cv13.put(colemail,"er.mohitdua@gmail.com");
        cv13.put(colcontact,"+91-1744-233479,+91-1744-233486");
        db.insert(TABLE_NAME, null, cv13);

        ContentValues cv14 = new ContentValues();
        cv14.put(colname,"Ritu Garg");
        cv14.put(coldesignation,"Assistant Professor");
        cv14.put(coldepartment,"Computer engineering");
        cv14.put(colqualification,"PhD (NIT Kurukshetra)2016");
        cv14.put(coladdress,"N/A");
        cv14.put(colemail,"ritu.59@nitkkr.ac.in");
        cv14.put(colcontact,"01744-233493");
        db.insert(TABLE_NAME, null, cv14);

        ContentValues cv15 = new ContentValues();
        cv15.put(colname,"Virender Ranga");
        cv15.put(coldesignation,"Assistant Professor");
        cv15.put(coldepartment,"Computer engineering");
        cv15.put(colqualification,"PhD");
        cv15.put(coladdress,"N/A");
        cv15.put(colemail,"virender.ranga@nitkkr.ac.in,virendersinghmtech@gmail.com");
        cv15.put(colcontact,"+919416158283,01744-233545");
        db.insert(TABLE_NAME, null, cv15);


        ContentValues cv16 = new ContentValues();
        cv16.put(colname,"Vikram Singh");
        cv16.put(coldesignation,"Assistant Professor");
        cv16.put(coldepartment,"Computer engineering");
        cv16.put(colqualification,"Ph.D. (Pursuing, NIT Kurukshetra), M.Tech. (SC&SS JNU New Delhi)");
        cv16.put(coladdress,"N/A");
        cv16.put(colemail,"viks@nitkkr.ac.in");
        cv16.put(colcontact,"01744-233530");
        db.insert(TABLE_NAME, null, cv16);

        ContentValues cv17 = new ContentValues();
        cv17.put(colname,"Gyanendra Kumar Verma");
        cv17.put(coldesignation,"Assistant Professor");
        cv17.put(coldepartment,"Computer engineering");
        cv17.put(colqualification,"Ph.D. (IIIT Allahabad)");
        cv17.put(coladdress,"N/A");
        cv17.put(colemail,"gyanendra@ieee.org,gyanendra@nitkkr.ac.in");
        cv17.put(colcontact,"01744-233530,7404210632");
        db.insert(TABLE_NAME, null, cv17);


        ContentValues cv18 = new ContentValues();
        cv18.put(colname,"Mahendra Kumar Murmu");
        cv18.put(coldesignation,"Assistant Professor");
        cv18.put(coldepartment,"Computer engineering");
        cv18.put(colqualification,"PhD (NIT Kurukshetra), M. Tech. (IIT(ISM) Dhanbad), B. Sc. Engg. (BIT Sindri)");
        cv18.put(coladdress,"N/A");
        cv18.put(colemail,"mkmurmu@nitkkr.ac.in,mkmurmu9@gmail.com");
        cv18.put(colcontact,"01744-233539");
        db.insert(TABLE_NAME, null, cv18);


        ContentValues cv19 = new ContentValues();
        cv19.put(colname,"Santosh Kumar");
        cv19.put(coldesignation,"Assistant Professor");
        cv19.put(coldepartment,"Computer engineering");
        cv19.put(colqualification,"PhD (Pursuing) NIT Kurukshetra, M.Tech (CSE) NIT JALANDHAR, B.Tech (CSE) IET Lucknow");
        cv19.put(coladdress,"N/A");
        cv19.put(colemail,"santosh.cse@nitkkr.ac.in,santosh.nitk@ieee.org");
        cv19.put(colcontact,"N/A");
        db.insert(TABLE_NAME, null, cv19);

        ContentValues cv20 = new ContentValues();
        cv20.put(colname,"Anoop Kumar Patel");
        cv20.put(coldesignation,"Assistant Professor");
        cv20.put(coldepartment,"Computer engineering");
        cv20.put(colqualification,"PhD (Pursuing),");
        cv20.put(coladdress,"N/A");
        cv20.put(colemail,"anooppatelk@gmail.com,akp@nitkkr.ac.in");
        cv20.put(colcontact,"8950459580");
        db.insert(TABLE_NAME, null, cv20);

        ContentValues cv21 = new ContentValues();
        cv21.put(colname,"Kriti Bhushan");
        cv21.put(coldesignation,"Assistant Professor");
        cv21.put(coldepartment,"Computer engineering");
        cv21.put(colqualification,"PhD (Pursuing),");
        cv21.put(coladdress,"N/A");
        cv21.put(colemail,"kriti.nitr@gmail.com,kritibhushan@nitkkr.ac.in");
        cv21.put(colcontact,"01744-233558");
        db.insert(TABLE_NAME, null, cv21);

        ContentValues cv22 = new ContentValues();
        cv22.put(colname,"Ankit Kumar Jain");
        cv22.put(coldesignation,"Assistant Professor");
        cv22.put(coldepartment,"Computer engineering");
        cv22.put(colqualification,"PhD (Pursuing)");
        cv22.put(coladdress,"N/A");
        cv22.put(colemail,"ankit.jain2407@gmail.com,ankitjain@nitkkr.ac.in");
        cv22.put(colcontact,"01744-233489");
        db.insert(TABLE_NAME, null, cv22);

        ContentValues cv23 = new ContentValues();
        cv23.put(colname,"Chandra Bhim Bhan Singh");
        cv23.put(coldesignation,"Assistant Professor");
        cv23.put(coldepartment,"Computer engineering");
        cv23.put(colqualification,"PhD (Pursuing)");
        cv23.put(coladdress,"N/A");
        cv23.put(colemail,"bhimbhan@gmail.com,cbsingh@nitkkr.ac.in");
        cv23.put(colcontact,"01744233489");
        db.insert(TABLE_NAME, null, cv23);


        ContentValues cv24 = new ContentValues();
        cv24.put(colname,"Vijay Verma");
        cv24.put(coldesignation,"Assistant Professor");
        cv24.put(coldepartment,"Computer engineering");
        cv24.put(colqualification,"PhD (Pursuing),");
        cv24.put(coladdress,"N/A");
        cv24.put(colemail,"vermavijay1986@gmail.com , vermavijay@nitkkr.ac.in");
        cv24.put(colcontact,"01744-233479");
        db.insert(TABLE_NAME, null, cv24);


        ContentValues cv25 = new ContentValues();
        cv25.put(colname,"Deepak Sharma");
        cv25.put(coldesignation,"Assistant Professor");
        cv25.put(coldepartment,"Computer engineering");
        cv25.put(colqualification,"PhD ");
        cv25.put(coladdress,"N/A");
        cv25.put(colemail,"sharmadeepak2k4@gmail.com");
        cv25.put(colcontact,"9416189230");
        db.insert(TABLE_NAME, null, cv25);

        ContentValues cv26 = new ContentValues();
        cv26.put(colname,"Minakshi Sharma");
        cv26.put(coldesignation,"Assistant Professor");
        cv26.put(coldepartment,"Computer engineering");
        cv26.put(colqualification,"PhD");
        cv26.put(coladdress,"N/A");
        cv26.put(colemail,"minakshi.it@rediffmail.com");
        cv26.put(colcontact,"8708285123");
        db.insert(TABLE_NAME, null, cv26);


        ContentValues cv27 = new ContentValues();
        cv27.put(colname,"Janardan Kumar Verma");
        cv27.put(coldesignation,"Assistant Professor");
        cv27.put(coldepartment,"Computer engineering");
        cv27.put(colqualification,"PhD");
        cv27.put(coladdress,"N/A");
        cv27.put(colemail,"janardan18@gmail.com");
        cv27.put(colcontact,"9990911268");
        db.insert(TABLE_NAME, null, cv27);


        ContentValues cv28 = new ContentValues();
        cv28.put(colname,"Kanupriya Kashyap");
        cv28.put(coldesignation,"Assistant Professor");
        cv28.put(coldepartment,"Computer engineering");
        cv28.put(colqualification,"M.Tech");
        cv28.put(coladdress,"N/A");
        cv28.put(colemail,"kanupriya_kashyap@yahoo.com");
        cv28.put(colcontact,"9466962973");
        db.insert(TABLE_NAME, null, cv28);

        ContentValues cv29 = new ContentValues();
        cv29.put(colname,"Mamtesh");
        cv29.put(coldesignation,"Assistant Professor");
        cv29.put(coldepartment,"Computer engineering");
        cv29.put(colqualification,"M.Tech ");
        cv29.put(coladdress,"N/A");
        cv29.put(colemail,"mamteshnadiyan49@gmail.com");
        cv29.put(colcontact,"8053425982");
        db.insert(TABLE_NAME, null, cv29);

        ContentValues cv30 = new ContentValues();
        cv30.put(colname,"Manali Singh Rajpoot");
        cv30.put(coldesignation,"Assistant Professor");
        cv30.put(coldepartment,"Computer engineering");
        cv30.put(colqualification,"M.Tech");
        cv30.put(coladdress,"N/A");
        cv30.put(colemail,"manali.rajput89@gmail.com");
        cv30.put(colcontact,"9770399447");
        db.insert(TABLE_NAME, null, cv30);


        ContentValues cv31 = new ContentValues();
        cv31.put(colname,"Manju Sharma");
        cv31.put(coldesignation,"Assistant Professor");
        cv31.put(coldepartment,"Computer engineering");
        cv31.put(colqualification,"M.Tech");
        cv31.put(coladdress,"N/A");
        cv31.put(colemail,"manjusharmaknl@gmail.com");
        cv31.put(colcontact,"9466705257");
        db.insert(TABLE_NAME, null, cv31);

        ContentValues cv32 = new ContentValues();
        cv32.put(colname,"Megha Gaur");
        cv32.put(coldesignation,"Assistant Professor");
        cv32.put(coldepartment,"Computer engineering");
        cv32.put(colqualification,"M.Tech");
        cv32.put(coladdress,"N/A");
        cv32.put(colemail,"anumeghagaur@gmail.com");
        cv32.put(colcontact,"7076302631");
        db.insert(TABLE_NAME, null, cv32);


        ContentValues cv33 = new ContentValues();
        cv33.put(colname,"Mukesh Kumar");
        cv33.put(coldesignation,"Assistant Professor");
        cv33.put(coldepartment,"Computer engineering");
        cv33.put(colqualification,"M.Tech");
        cv33.put(coladdress,"N/A");
        cv33.put(colemail,"mk.verma113@gmail.com");
        cv33.put(colcontact,"9996395619");
        db.insert(TABLE_NAME, null, cv33);


        ContentValues cv34 = new ContentValues();
        cv34.put(colname,"Neha Miglani");
        cv34.put(coldesignation,"Assistant Professor");
        cv34.put(coldepartment,"Computer engineering");
        cv34.put(colqualification,"M.Tech");
        cv34.put(coladdress,"N/A");
        cv34.put(colemail,"neha.miglani27@gmail.com");
        cv34.put(colcontact,"9896682220");
        db.insert(TABLE_NAME, null, cv34);

        ContentValues cv35 = new ContentValues();
        cv35.put(colname,"Premlata Yadav");
        cv35.put(coldesignation,"Assistant Professor");
        cv35.put(coldepartment,"Computer engineering");
        cv35.put(colqualification,"M.Tech");
        cv35.put(coladdress,"N/A");
        cv35.put(colemail,"yadav.premlata15@gmail.com");
        cv35.put(colcontact,"9468410369");
        db.insert(TABLE_NAME, null, cv35);


        ContentValues cv36 = new ContentValues();
        cv36.put(colname,"Reenu Rani");
        cv36.put(coldesignation,"Assistant Professor");
        cv36.put(coldepartment,"Computer engineering");
        cv36.put(colqualification,"M.Tech ");
        cv36.put(coladdress,"N/A");
        cv36.put(colemail,"reenurani6@gmail.com");
        cv36.put(colcontact,"8607487541");
        db.insert(TABLE_NAME, null, cv36);

        ContentValues cv37 = new ContentValues();
        cv37.put(colname,"Rekha Rani");
        cv37.put(coldesignation,"Assistant Professor");
        cv37.put(coldepartment,"Computer engineering");
        cv37.put(colqualification,"M.Tech");
        cv37.put(coladdress,"N/A");
        cv37.put(colemail,"rekhasaini07@gmail.com");
        cv37.put(colcontact,"8901393949");
        db.insert(TABLE_NAME, null, cv37);


        ContentValues cv38 = new ContentValues();
        cv38.put(colname,"Seema Mehla");
        cv38.put(coldesignation,"Assistant Professor");
        cv38.put(coldepartment,"Computer engineering");
        cv38.put(colqualification,"M.Tech");
        cv38.put(coladdress,"N/A");
        cv38.put(colemail,"seemamehlakkr@gmail.com");
        cv38.put(colcontact,"9466455874");
        db.insert(TABLE_NAME, null, cv38);


        ContentValues cv39 = new ContentValues();
        cv39.put(colname,"Smruti Rekha Swain");
        cv39.put(coldesignation,"Assistant Professor");
        cv39.put(coldepartment,"Computer engineering");
        cv39.put(colqualification,"M.Tech");
        cv39.put(coladdress,"N/A");
        cv39.put(colemail,"smruti.sai90@gmail.com");
        cv39.put(colcontact,"8901041994");
        db.insert(TABLE_NAME, null, cv39);



        ContentValues cv40 = new ContentValues();
        cv40.put(colname,"Sumit Kumar");
        cv40.put(coldesignation,"Assistant Professor");
        cv40.put(coldepartment,"Computer engineering");
        cv40.put(colqualification,"M.Tech");
        cv40.put(coladdress,"N/A");
        cv40.put(colemail,"sumitkhatana89@gmail.com");
        cv40.put(colcontact,"9813461797");
        db.insert(TABLE_NAME, null, cv40);


        ContentValues cv41 = new ContentValues();
        cv41.put(colname,"Seema Kanyan");
        cv41.put(coldesignation,"Assistant Professor");
        cv41.put(coldepartment,"Computer engineering");
        cv41.put(colqualification,"M.Tech");
        cv41.put(coladdress,"N/A");
        cv41.put(colemail,"cma.kanyan@gmail.com");
        cv41.put(colcontact,"8816813647");
        db.insert(TABLE_NAME, null, cv41);

        ContentValues cv42 = new ContentValues();
        cv42.put(colname,"Surjit Singh");
        cv42.put(coldesignation,"Assistant Professor");
        cv42.put(coldepartment,"Computer engineering");
        cv42.put(colqualification,"M.Tech");
        cv42.put(coladdress,"N/A");
        cv42.put(colemail,"surjitmehla@gmail.com");
        cv42.put(colcontact,"9728433699");
        db.insert(TABLE_NAME, null, cv42);


        ContentValues cv43 = new ContentValues();
        cv43.put(colname,"Vishal Pasricha");
        cv43.put(coldesignation,"Assistant Professor");
        cv43.put(coldepartment,"Computer engineering");
        cv43.put(colqualification,"PhD Pursuing (NIT, Kurukshetra)");
        cv43.put(coladdress,"N/A");
        cv43.put(colemail,"vishal_pasricha@yahoo.com");
        cv43.put(colcontact,"9354761220");
        db.insert(TABLE_NAME, null, cv43);

        ContentValues cv44 = new ContentValues();
        cv44.put(colname,"BB Gupta");
        cv44.put(coldesignation,"Assistant Professor");
        cv44.put(coldepartment,"Computer engineering");
        cv44.put(colqualification,"N/A");
        cv44.put(coladdress,"N/A");
        cv44.put(colemail,"N/A");
        cv44.put(colcontact,"N/A");
        db.insert(TABLE_NAME, null, cv44);

        ContentValues cv45 = new ContentValues();
        cv45.put(colname,"Prashant Kumar");
        cv45.put(coldesignation,"Student");
        cv45.put(coldepartment,"Computer Engineering");
        cv45.put(colqualification,"BTech (Pursuing)");
        cv45.put(coladdress,"N/A");
        cv45.put(colemail,"prax.cool@gmail.com");
        cv45.put(colcontact,"9053580166");
        db.insert(TABLE_NAME, null, cv45);

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
