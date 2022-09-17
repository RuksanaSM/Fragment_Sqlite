package com.example.employeefragmentsqllite.ui.emplist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.employeefragmentsqllite.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListFragment extends Fragment {
ListView listView;
//RecyclerView recyclerView;
DataReadHelper dataReadHelper;
SQLiteDatabase db;
    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    public EmployeeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_employee_list, container, false);
        listView=root.findViewById(R.id.listviewid);

        dataReadHelper=new DataReadHelper(getContext());
      db=dataReadHelper.getReadableDatabase();
      arrayAdapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,arrayList);
      listView.setAdapter(arrayAdapter);



        readdata();
        return  root;
    }
    public void readdata() {
        arrayList.clear();
        String[] col = {"Sno", "Name", "Desg","Addr"};
        Cursor cursor = db.query("emp", col, null, null, null, null, null);

        if (cursor.getCount() > 0 && cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(1);
                String desg = cursor.getString(2);
                String addr=cursor.getString(3);
                arrayList.add("Name :" + name + "\nDesignation :" + desg+"\nAddress :"+addr);
                arrayAdapter.notifyDataSetChanged();

            }
        } else {
            Toast.makeText(getContext(), "No Record Found", Toast.LENGTH_SHORT).show();
        }

    }
}