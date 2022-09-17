package com.example.employeefragmentsqllite.ui.employee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataHelperClass extends SQLiteOpenHelper {
    Context context;
    public DataHelperClass(@Nullable Context context) {
        super(context, "EmpDatabase.db", null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table emp(Sno Integer primary key,Name text,Desg text,Addr text)");
        Toast.makeText(context, "Sql Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public long createMethod(SQLiteDatabase db, int sno, String name, String desg, String addr) {
        ContentValues cv=new ContentValues();
        cv.put("Sno",sno);
        cv.put("Name",name);
        cv.put("Desg",desg);
        cv.put("Addr",addr);
      long set=db.insert("emp",null,cv);
      return  set;
    }
}
