package com.example.uniektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {

    TextView tvName,tvPhone;
    DbHelper DB;
    Adapter adapter;
    RecyclerView rvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tvPhone=findViewById(R.id.tvPhone);
       tvName=findViewById(R.id.tvName);
       // rvData=findViewById(R.id.rvData);
       DB=new DbHelper(this);

/*
        adapter=new Adapter(this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rvData.setAdapter(adapter);
        rvData.setLayoutManager(linearLayoutManager);*/


        String Name=tvName.getText().toString();
        String Phone=tvPhone.getText().toString();

        Cursor cursor=DB.getdata();



        if(cursor.getCount()==0){
            Toast.makeText(ViewActivity.this, "No Entry", Toast.LENGTH_SHORT).show();
            return;
        }else {
        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()) {

           tvName.setText(cursor.getString(0));
           tvPhone.setText(cursor.getString(1));
        }



        }
    }
}