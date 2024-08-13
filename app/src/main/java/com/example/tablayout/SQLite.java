package com.example.tablayout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SQLite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "RoadSigns";
    private static final int VERSION = 1;
    private final String TABLE_NAME = "SignData";
    private final String TABLE_NAME_2 = "Marks";
    private final String TABLE_NAME_Wrong_Ans = "WrongAns";

    private final String COL_1 = "Images";
    private final String COL_2 = "Dis";



    public SQLite(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Create_Table = "CREATE TABLE "+ TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_1 + " BLOB, "+ COL_2 + " TEXT)";
        String Create_Table_Wrong_Ans = "CREATE TABLE "+ TABLE_NAME_Wrong_Ans + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_1 + " BLOB, "+ COL_2 + " TEXT)";
        sqLiteDatabase.execSQL(Create_Table);
        sqLiteDatabase.execSQL(Create_Table_Wrong_Ans);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME_Wrong_Ans);

        onCreate(sqLiteDatabase);

    }

    public void  save(Datamode data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,data.getImage());
        contentValues.put(COL_2,data.getDis());
        db.insert(TABLE_NAME,null,contentValues);
    }

    public void  saveWrongAns(Datamode data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,data.getImage());
        contentValues.put(COL_2,data.getDis());
        db.insert(TABLE_NAME_Wrong_Ans,null,contentValues);
    }


    public void deleteWrongAns(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME_Wrong_Ans,null,null);
    }


    public ArrayList<Datamode> getdata(int min, int max){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from SignData WHERE ID BETWEEN "+min+" AND "+max , null);

        ArrayList<Datamode> data = new ArrayList<>();

        while (cursor.moveToNext()){

            byte[] img = cursor.getBlob(1);
            String discription = cursor.getString(2);

            Datamode datamodel = new Datamode(discription,img);
            data.add(datamodel);
        }
        cursor.close();

        return data;

    }

    public ArrayList<Datamode> getWrongAnsData(){

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME_Wrong_Ans , null);

        ArrayList<Datamode> data = new ArrayList<>();

        while (cursor.moveToNext()){

            byte[] img = cursor.getBlob(1);
            String discription = cursor.getString(2);

            Datamode datamodel = new Datamode(discription,img);
            data.add(datamodel);
        }
        cursor.close();

        return data;

    }

    public ArrayList<Datamode> getRandomData(){


        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" ORDER BY RANDOM() LIMIT 4", null);
        ArrayList<Datamode> data = new ArrayList<>();

        while (cursor.moveToNext()){

            byte[] img = cursor.getBlob(1);
            String discription = cursor.getString(2);

            Datamode datamodel = new Datamode(discription,img);
            data.add(datamodel);
        }


        return data;

    }
}

