package com.app.dietchartfinal.utility;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbAdapter {
    myDbHelper myhelper;

    public MyDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name,String gender,String age,String hight,String disease,String question,String ans,String username,String email, String pass) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.GENDER, gender);
        contentValues.put(myDbHelper.AGE, age);
        contentValues.put(myDbHelper.HEIGHT, hight);
        contentValues.put(myDbHelper.DISEASE, disease);
        contentValues.put(myDbHelper.QUESTION, question);
        contentValues.put(myDbHelper.ANS, ans);
        contentValues.put(myDbHelper.USERNAME, username);
        contentValues.put(myDbHelper.EMAIL, email);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.GENDER, myDbHelper.AGE, myDbHelper.HEIGHT,
                myDbHelper.DISEASE, myDbHelper.QUESTION, myDbHelper.ANS, myDbHelper.USERNAME, myDbHelper.EMAIL, myDbHelper.MyPASSWORD};

        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            @SuppressLint("Range") String GENDER = cursor.getString(cursor.getColumnIndex(myDbHelper.GENDER));
            @SuppressLint("Range") String AGE = cursor.getString(cursor.getColumnIndex(myDbHelper.AGE));
            @SuppressLint("Range") String HEIGHT = cursor.getString(cursor.getColumnIndex(myDbHelper.HEIGHT));
            @SuppressLint("Range") String DISEASE = cursor.getString(cursor.getColumnIndex(myDbHelper.DISEASE));
            @SuppressLint("Range") String QUESTION = cursor.getString(cursor.getColumnIndex(myDbHelper.QUESTION));
            @SuppressLint("Range") String ANS = cursor.getString(cursor.getColumnIndex(myDbHelper.ANS));
            @SuppressLint("Range") String USERNAME = cursor.getString(cursor.getColumnIndex(myDbHelper.USERNAME));
            @SuppressLint("Range") String EMAIL = cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            buffer.append(cid + "   " + name+ "   " + GENDER+ "   " + AGE+ "   " + HEIGHT+ "   " + DISEASE+ "   " + QUESTION+ "   " +
                    ANS+ "   " + USERNAME+ "   " + EMAIL + "   " + password + " \n");
        }
        return buffer.toString();
    }
    public Boolean getLoginState(String namegiven,String passwordgiven) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.GENDER, myDbHelper.AGE, myDbHelper.HEIGHT,
                myDbHelper.DISEASE, myDbHelper.QUESTION, myDbHelper.ANS, myDbHelper.USERNAME, myDbHelper.EMAIL, myDbHelper.MyPASSWORD};

        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            @SuppressLint("Range") String GENDER = cursor.getString(cursor.getColumnIndex(myDbHelper.GENDER));
            @SuppressLint("Range") String AGE = cursor.getString(cursor.getColumnIndex(myDbHelper.AGE));
            @SuppressLint("Range") String HEIGHT = cursor.getString(cursor.getColumnIndex(myDbHelper.HEIGHT));
            @SuppressLint("Range") String DISEASE = cursor.getString(cursor.getColumnIndex(myDbHelper.DISEASE));
            @SuppressLint("Range") String QUESTION = cursor.getString(cursor.getColumnIndex(myDbHelper.QUESTION));
            @SuppressLint("Range") String ANS = cursor.getString(cursor.getColumnIndex(myDbHelper.ANS));
            @SuppressLint("Range") String USERNAME = cursor.getString(cursor.getColumnIndex(myDbHelper.USERNAME));
            @SuppressLint("Range") String EMAIL = cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
           if(USERNAME.equals(namegiven)&&password.equals(passwordgiven)){
               return true;
           }
        }
        return false;
    }
    public String getAge(String namegiven,String passwordgiven) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.NAME, myDbHelper.GENDER, myDbHelper.AGE, myDbHelper.HEIGHT,
                myDbHelper.DISEASE, myDbHelper.QUESTION, myDbHelper.ANS, myDbHelper.USERNAME, myDbHelper.EMAIL, myDbHelper.MyPASSWORD};

        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            @SuppressLint("Range") String GENDER = cursor.getString(cursor.getColumnIndex(myDbHelper.GENDER));
            @SuppressLint("Range") String AGE = cursor.getString(cursor.getColumnIndex(myDbHelper.AGE));
            @SuppressLint("Range") String HEIGHT = cursor.getString(cursor.getColumnIndex(myDbHelper.HEIGHT));
            @SuppressLint("Range") String DISEASE = cursor.getString(cursor.getColumnIndex(myDbHelper.DISEASE));
            @SuppressLint("Range") String QUESTION = cursor.getString(cursor.getColumnIndex(myDbHelper.QUESTION));
            @SuppressLint("Range") String ANS = cursor.getString(cursor.getColumnIndex(myDbHelper.ANS));
            @SuppressLint("Range") String USERNAME = cursor.getString(cursor.getColumnIndex(myDbHelper.USERNAME));
            @SuppressLint("Range") String EMAIL = cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex(myDbHelper.MyPASSWORD));
            if(USERNAME.equals(namegiven)&&password.equals(passwordgiven)){
                return AGE;
            }
        }
        return "";
    }
    public int delete(String uname) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {uname};

        int count = db.delete(myDbHelper.TABLE_NAME, myDbHelper.NAME + " = ?", whereArgs);
        return count;
    }

    public boolean updateName(String oldName, String newName,String oldPass, String newPass) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.USERNAME, newName);
        String[] whereArgs = {oldName};
        db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.USERNAME + " = ?", whereArgs);

        SQLiteDatabase db1 = myhelper.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(myDbHelper.MyPASSWORD, newPass);
        String[] whereArgs1 = {oldPass};
        db1.update(myDbHelper.TABLE_NAME, contentValues1, myDbHelper.MyPASSWORD + " = ?", whereArgs1);

       // int count = db.update(myDbHelper.TABLE_NAME, contentValues, myDbHelper.USERNAME + " = ?", whereArgs);
        return true;
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "DietChartFinal";    // Database Name
        private static final String TABLE_NAME = "USERTABLE";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String GENDER = "GENDER";    //Column III
        private static final String AGE = "AGE";    //Column IV
        private static final String HEIGHT = "HEIGHT";    //Column V
        private static final String DISEASE = "DISEASE";    //Column VI
        private static final String QUESTION = "QUESTION";    //Column VII
        private static final String ANS = "ANS";    //Column II
        private static final String USERNAME = "USERNAME";    //Column VIII
        private static final String EMAIL = "EMAIL";    //Column IX
        private static final String MyPASSWORD = "Password";    // Column X


        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ,"
                + GENDER + " VARCHAR(255)," +
                AGE + " VARCHAR(255)," + HEIGHT + " VARCHAR(255)," + DISEASE + " VARCHAR(255),"
                + QUESTION + " VARCHAR(255)," + ANS + " VARCHAR(255)," + USERNAME + " VARCHAR(255)," + EMAIL +
                " VARCHAR(255)," + MyPASSWORD + " VARCHAR(225));";


        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }
    }
}