package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS events (event VARCHAR, year INT(4))");
        //mydatabase.execSQL("INSERT INTO  events (event, year) VALUES('PARTY', 2009)");
        //mydatabase.execSQL("INSERT INTO events (event, year) VALUES('Stock', 2013)");

        Cursor c = mydatabase.rawQuery("SELECT * FROM events", null);

        int eventIndex = c.getColumnIndex("event");
        int yearIndex = c.getColumnIndex("year");
        ;

        if(c.moveToFirst()){
            do{
                Log.i("Event is following", c.getString(eventIndex));
                Log.i("Year is following", c.getString(yearIndex));
            }while(c.moveToNext());
        }
        c.close();
    }
}