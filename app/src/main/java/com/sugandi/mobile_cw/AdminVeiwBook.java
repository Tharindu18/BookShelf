package com.sugandi.mobile_cw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AdminVeiwBook extends AppCompatActivity {

    Button btnBack;
    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    MyDatabaseHelper myDB;
    ArrayList<String> B_id, B_name, B_Author, B_Quntity, B_price;
    CustomerAdapterBookView customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_veiw_book);

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminVeiwBook.this, AdminHomePage.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.addButton);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminVeiwBook.this, AdminBookAddPage.class);
                startActivity(intent);
                finish();
            }
        });

        myDB = new MyDatabaseHelper(AdminVeiwBook.this);
        B_id = new ArrayList<>();
        B_name = new ArrayList<>();
        B_Author = new ArrayList<>();
        B_Quntity = new ArrayList<>();
        B_price = new ArrayList<>();

        storeInArray();

        customerAdapter = new CustomerAdapterBookView(AdminVeiwBook.this,
                B_id, B_name, B_price, B_Quntity);
        recyclerView.setAdapter(customerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminVeiwBook.this));


    }

    void storeInArray() {
        Cursor cursor = myDB.ReadB_tb();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                B_id.add(cursor.getString(0));
                B_name.add(cursor.getString(1));
                B_Author.add(cursor.getString(2));
                B_Quntity.add(cursor.getString(3));
                B_price.add(cursor.getString(4));
            }
        }
    }
}