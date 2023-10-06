package com.sugandi.mobile_cw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static int DATABASE_VERSION = 1;

    //create user table
    private static final String TABLE_NAME = "user_tb";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_USERNAME = "userName";
    private static final String COLUMN_PW = "password";

    //create book table
    private static final String BOOK_TB_NAME = "book_detail_tb";
//    private static final String COLUMN_BOOK_ID = "book_id";
//    private static final String COLUMN_BOOK_NAME = "book_Name";
//    private static final String COLUMN_BOOK_AUTHOR = "author_name";
//    private static final String COLUMN_BOOK_PRICE = "book_price";
//    private static final String COLUMN_BOOK_QUANTITY = "book_quantity";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //user table
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PW + " INTEGER);";
        db.execSQL(query);

        //book table
//        String bookQuery = "CREATE TABLE " + BOOK_TB_NAME +
//                " (" + COLUMN_BOOK_ID + " TEXT PRIMARY KEY, " +
//                COLUMN_BOOK_NAME + " TEXT, " +
//                COLUMN_BOOK_AUTHOR + " TEXT, " +
//                COLUMN_BOOK_PRICE + " INTEGER," +
//                COLUMN_BOOK_QUANTITY + " INTEGER);";

        String bookQuery = "CREATE TABLE book_detail_tb " +
                "( book_id TEXT PRIMARY KEY, " +
                "book_Name TEXT, " +
                "author_name TEXT, " +
                "book_price INTEGER, " +
                "book_quantity  INTEGER);";
        db.execSQL(bookQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TB_NAME);
        onCreate(db);
    }

    // User table data insert
    public void addUser(String uname, String pw) {
        long result;
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues cv = new ContentValues();

            cv.put(COLUMN_USERNAME, uname);
            cv.put(COLUMN_PW, pw);

            result = db.insert(TABLE_NAME, null, cv);
        }

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean checkUnPw(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user_tb WHERE userName = ? AND password = ?", new String[]{username, password});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // book table data insert
    public void addBook(String B_id, String B_name, String B_author, Integer B_quntity, Integer B_price) {
        long result;
        try (SQLiteDatabase db = this.getWritableDatabase()) {
            ContentValues Bcv = new ContentValues();

//            Bcv.put(COLUMN_BOOK_ID, B_id);
//            Bcv.put(COLUMN_BOOK_NAME, B_name);
//            Bcv.put(COLUMN_BOOK_AUTHOR, B_author);
//            Bcv.put(COLUMN_BOOK_QUANTITY, B_quntity);
//            Bcv.put(COLUMN_BOOK_PRICE, B_price);

//            result = db.insert(BOOK_TB_NAME, null, Bcv);

            Bcv.put("book_id", B_id);
            Bcv.put("book_Name", B_name);
            Bcv.put("author_name", B_author);
            Bcv.put("book_price", B_quntity);
            Bcv.put("book_quantity", B_price);

            result = db.insert("book_detail_tb", null, Bcv);
        }

        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor ReadB_tb(){
        String query = "SELECT * FROM " + BOOK_TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
