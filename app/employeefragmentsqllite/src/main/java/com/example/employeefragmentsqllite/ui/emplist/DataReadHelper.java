package com.example.employeefragmentsqllite.ui.emplist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataReadHelper extends SQLiteOpenHelper {
    Context context;

    public DataReadHelper(@Nullable Context context) {
        super(context,"EmpDatabase.db", null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    }

