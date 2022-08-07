package com.example.uniektask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText edName,edPhone;
    Button BtSave;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        BtSave=findViewById(R.id.BtSave);
        edName=findViewById(R.id.edName);
        edPhone=findViewById(R.id.edPhone);
        DB=new DbHelper(this);

        BtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=edName.getText().toString();
                String Phone=edPhone.getText().toString();
                Boolean insertData=DB.insert(Name,Phone);

                if (insertData==true){
                    Toast.makeText(InsertActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(InsertActivity.this, "Already inserted ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}