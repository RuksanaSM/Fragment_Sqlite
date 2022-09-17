package com.example.employeefragmentsqllite.ui.employee;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.employeefragmentsqllite.R;

import java.util.ArrayList;

public class HomeEmployeeFragment extends Fragment {

    EditText name,sno,desg,addr;

   DataHelperClass dataHelperClass;
    SQLiteDatabase db;

    String namestr,desgstr,addrstr;
    int value;
Button insert;
//    Cursor cursor;

    ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    public HomeEmployeeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_home_employee, container, false);

        name=root.findViewById(R.id.empnameid);
        sno=root.findViewById(R.id.empsnoid);
        desg= root.findViewById(R.id.empdesgid);
        addr=root.findViewById(R.id.empaddrsid);

        dataHelperClass=new DataHelperClass(getContext());
        db=dataHelperClass.getReadableDatabase();

        insert=root.findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namestr=name.getText().toString();
                desgstr=desg.getText().toString();
                addrstr=addr.getText().toString();
                value= Integer.parseInt(sno.getText().toString());

                long set=dataHelperClass.createMethod(db,value,namestr,desgstr,addrstr);

                if (set== -1)
                {
                    Toast.makeText(getContext(), "Record already Existed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(), "New Reord inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return  root;
    }


}