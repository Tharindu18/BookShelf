package com.sugandi.mobile_cw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHomePage extends AppCompatActivity {

    Button bookBtn, shopBtn, orderBtn, btnlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        bookBtn = findViewById(R.id.btnBookDetail);
        shopBtn = findViewById(R.id.btnOrderDetail);
        orderBtn = findViewById(R.id.btnOrderDetail);
        btnlogout = findViewById(R.id.btnLogout);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomePage.this,AdminVeiwBook.class);
                startActivity(intent);
                finish();
            }
        });

        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomePage.this,AdminShopDetail.class);
                startActivity(intent);
                finish();
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomePage.this,AdminVeiwOrder.class);
                startActivity(intent);
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomePage.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}