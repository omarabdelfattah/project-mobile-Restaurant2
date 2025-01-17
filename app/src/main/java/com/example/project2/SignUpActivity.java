package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {

    EditText UserName, PassWord, ConPassWord, EmailAddress, Phone;
    String Username ,password,conPass,Email_Address,phone;

    public void Inputuser(View v)
    {
         Username      = UserName.getText().toString();
         password      = PassWord.getText().toString();
         conPass       = ConPassWord.getText().toString();
         Email_Address = EmailAddress.getText().toString();
         phone         = Phone.getText().toString();

        switch (check())
        {
            case 0:
            {
                Toast.makeText(SignUpActivity.this, "make sure you fill all fields", Toast.LENGTH_SHORT).show();
                break;
            }
            case 1:
            {
                Toast.makeText(SignUpActivity.this, "please confirm password correctly", Toast.LENGTH_SHORT).show();
                break;
            }
            case 2:
            {
                saveCurrentUser();
                Intent intent = new Intent(this, log_in.class);
                startActivity(intent);
                break;
            }
        }
    }

    public int check()
    {
        if (UserName.getText().toString().equals("")|PassWord.getText().toString().equals("")|ConPassWord.getText().toString().equals("")|EmailAddress.getText().toString().equals("")|Phone.getText().toString().equals(""))
            return 0;
        else if(!PassWord.getText().toString().equals(ConPassWord.getText().toString()))
            return 1;
        else
            return 2;
    }
    private Button signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
         UserName     = (EditText) findViewById(R.id.susername);
         ConPassWord  = (EditText) findViewById(R.id.spassword2);
         PassWord     = (EditText) findViewById(R.id.spassword);
         EmailAddress = (EditText) findViewById(R.id.semail);
         Phone        = (EditText) findViewById(R.id.sphonenum);
    }



    public void saveCurrentUser()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",Username);
        editor.putString("password",password);
        editor.putString("phone",phone);
        editor.putString("email",Email_Address);

        editor.apply();
    }
}