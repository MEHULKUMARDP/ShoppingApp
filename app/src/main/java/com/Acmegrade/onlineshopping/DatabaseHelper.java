package com.Acmegrade.onlineshopping;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//First we create DatabaseHelper class and then extends SQLiteOpenHelper and then implements methods and also create one constructor

public class DatabaseHelper extends SQLiteOpenHelper {

    //private- Outside this class...you can't use this variable
    //static- Without making object...you can access variable directly(In making query)
    //final- You can't change a value(Column name)

    //Note: Database Version then .db file then table then column

    //Database Version
    private static final int DATABASE_VERSION = 1;
    //Database name
    private static final String DATABASE_NAME = "UserManager.db";
    //User table name
    private static final String TABLE_USER = "user";
    //User Table Columns name
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    //Query to create a table in SQLite
    //CREATE TABLE user (user_id datatype, user_name datatype, user_email datatype, user_password datatype);

    //Create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    //drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //We make this another constructor and insert super method and its parameters
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQLiteDatabase db from this...execute query of create table which assigned in CREATE_USER_TABLE variable
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //For registration
    public boolean checkUser(String email)
    {
        //Array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };

        SQLiteDatabase db = this.getReadableDatabase();
        //selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";
        //selection argument
        String[] selectionArgs = {
                email
        };

        //query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email =  'mehulprajapati@gmail.com';
         */

        //Result of a query...we use Cursor class
        //It returns integer value ....if greater than 0 then similar records of the email already found
        //if value is 0 or less than 0 then no similar records are found

        Cursor cursor = db.query(TABLE_USER,  //Table to query
                columns,                      //columns to return
                selection,                    //columns for the WHERE clause
                selectionArgs,                //The values for the WHERE clause
                null,                         //groupBy: group the rows
                null,                         //having: filter by row groups
                null);                        //orderBy: The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount>0)
        {
            return true;
        }
        return false;
    }

    //for login
    public boolean checkUser(String email, String password)
    {
        //Array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };

        SQLiteDatabase db = this.getReadableDatabase();
        //selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
        //selection argument
        String[] selectionArgs = {
                email, password
        };

        //query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email =  'mehulprajapati@gmail.com' AND user_password = 'confirm';
         */
        Cursor cursor = db.query(TABLE_USER,  //Table to query
                columns,                      //columns to return
                selection,                    //columns for the WHERE clause
                selectionArgs,                //The values for the WHERE clause
                null,                         //groupBy: group the rows
                null,                         //having: filter by row groups
                null);                        //orderBy: The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if(cursorCount>0)
        {
            return true;
        }
        return false;
    }

    //To insert the record in our table we use ContentValues class
    public void addUser(User user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //The ContentValues class provides methods to put data into the ContentValues object. Each piece of data is identified by a key and a value. The key is a String that represents the name of the column in the database table, and the value can be one of several types, including String, Integer, Boolean, Float, Double, and Byte array.
        ContentValues values = new ContentValues();
        //First parameter in which column and second get values which are put in specific column
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        //Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    //The name attached to the given email will return
    @SuppressLint("Range")
    public String getNameFromEmail(String email) {
        String name = null;
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {COLUMN_USER_NAME};
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
        }
        cursor.close();
        return name;
    }
}
