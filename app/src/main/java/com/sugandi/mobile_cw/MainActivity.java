package com.sugandi.mobile_cw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextUN;
    TextInputEditText editTextPassword;
    Button buttonLogin;
    ProgressBar progressBar;
    TextView textVeiw;

    MyDatabaseHelper myDB;
    ArrayList<String> userName, userpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUN = findViewById(R.id.un);
        editTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btnlogin);
        progressBar = findViewById(R.id.progessBar);
        textVeiw = findViewById(R.id.RegisterNow);

        myDB = new MyDatabaseHelper(this);

        textVeiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,registerForm.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = String.valueOf(editTextUN.getText());
                String pw = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(uname)){
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pw)){
                    Toast.makeText(MainActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

               if (uname.equals("admin") && pw.equals("1234")){
                   Intent intent = new Intent(MainActivity.this,AdminHomePage.class);
                   startActivity(intent);
                   finish();
               }

               else {
                   Boolean checkuserUnPw = myDB.checkUnPw(uname, pw);
                   Toast.makeText(MainActivity.this, String.valueOf(checkuserUnPw), Toast.LENGTH_SHORT).show();
                   if (checkuserUnPw==true){
                       Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                       Intent intent = new Intent(MainActivity.this,UserHomePage.class);
                       startActivity(intent);
                       finish();
                   }

                   else {
                       Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                   }
               }
            }
        });
    }

}