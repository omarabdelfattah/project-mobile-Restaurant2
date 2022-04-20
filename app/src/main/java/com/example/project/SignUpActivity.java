package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText UserName, PassWord, ConPassWord, EmailAddress, Phone;


public void Inputuser(View v) {

    String Username = UserName.getText().toString();
    String PassWord = UserName.getText().toString();
    String EmailAddress = UserName.getText().toString();
    String Phone = UserName.getText().toString();

    Account InputUser = new Account(Username, PassWord, Phone, EmailAddress);
    Account.users.add(InputUser);
    Intent intent = new Intent(this, log_in.class);

    startActivity(intent);
    }

    private Button signUp;
    @Override




    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


         UserName = (EditText) findViewById(R.id.susername);
         ConPassWord = (EditText) findViewById(R.id.spassword);
         PassWord = (EditText) findViewById(R.id.sphonenum);
         EmailAddress = (EditText) findViewById(R.id.semail);
         Phone = (EditText) findViewById(R.id.sphonenum);





    }
}