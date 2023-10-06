package com.sugandi.mobile_cw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminBookAddPage extends AppCompatActivity {

    EditText B_id, B_name, B_author, B_price, B_quantity;
    Button btnAddBook,btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_book_add_page);

        B_id = findViewById(R.id.bookID);
        btnback = findViewById(R.id.btnback1);
        B_name = findViewById(R.id.bookName);
        B_quantity = findViewById(R.id.bookQuantity);
        B_author = findViewById(R.id.bookAuthor);
        B_price = findViewById(R.id.bookPrice);

        btnAddBook = findViewById(R.id.btnInsertBook);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminBookAddPage.this, AdminVeiwBook.class);
                startActivity(intent);
                finish();
            }
        });

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(AdminBookAddPage.this);
                myDB.addBook(B_id.getText().toString().trim(),
                        B_name.getText().toString().trim(),
                        B_author.getText().toString().trim(),
                        Integer.valueOf(B_quantity.getText().toString().trim()),
                        Integer.valueOf(B_price.getText().toString().trim()));
            }
        });

    }
}