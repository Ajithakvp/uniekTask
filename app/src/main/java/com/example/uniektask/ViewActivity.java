package com.example.uniektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    TextView tvName,tvPhone;
    DbHelper DB;
    Adapter adapter;
    RecyclerView rvData;

    ArrayList<String> Name,Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tvPhone=findViewById(R.id.tvPhone);
       tvName=findViewById(R.id.tvName);
       rvData=findViewById(R.id.rvData);
       DB=new DbHelper(this);
       Name =new ArrayList<>();
       Phone=new ArrayList<>();


        adapter=new Adapter(this,Name,Phone);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvData.setAdapter(adapter);
        rvData.setLayoutManager(linearLayoutManager);


       // String Name=tvName.getText().toString();
        //String Phone=tvPhone.getText().toString();

        Cursor cursor=DB.getdata();



        if(cursor.getCount()==0){
            Toast.makeText(ViewActivity.this, "No Entry", Toast.LENGTH_SHORT).show();
            return;
        }else {
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()) {
Name.add(cursor.getString(0));
Phone.add(cursor.getString(1));
         //  tvName.setText(cursor.getString(0));
         //  tvPhone.setText(cursor.getString(1));
        }



        }
    }
}