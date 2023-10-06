package com.sugandi.mobile_cw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class registerForm extends AppCompatActivity {

    TextInputEditText editTextUN, editTextPassword;
    Button buttonReg;
    TextView textVeiw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        editTextUN = findViewById(R.id.UN);
        editTextPassword = findViewById(R.id.password);
        buttonReg = findViewById(R.id.btnRegister);
        textVeiw = findViewById(R.id.backLogin);

        textVeiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(registerForm.this);
                myDB.addUser(editTextUN.getText().toString().trim(),
                        editTextPassword.getText().toString().trim());
            }
        });
    }
}