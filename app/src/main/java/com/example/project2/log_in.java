package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.*;

public class log_in extends AppCompatActivity {

    private EditText userName,password;

    private Button logIn;

    private TextView signUp;

    public int userId = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        logIn = findViewById(R.id.button3);
        signUp = findViewById(R.id.signUpLink);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(userName.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(log_in.this,"Username and password required",Toast.LENGTH_LONG).show();
                }else{
                    // Proceed to login
                    login();
                }
            }
        });



//
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(userName.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(log_in.this,"Login Successfull",Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();

                    Log.d("token",loginResponse.getaccess_token());
                    Log.d("name",loginResponse.getUser().getname());

                    SharedPreferences session_info = getSharedPreferences("SESSION_INFO", MODE_PRIVATE);
                    SharedPreferences.Editor editor = session_info.edit();

                    editor.putString("name", loginResponse.getUser().getname()).commit();
                    editor.putString("email", loginResponse.getUser().getemail()).commit();
                    editor.putString("phone", loginResponse.getUser().getPhone()).commit();
                    editor.putString("credit_card", loginResponse.getUser().getCredit_card()).commit();
                    editor.putString("access_token",loginResponse.getaccess_token()).commit();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(
                                    new Intent(log_in.this,MainActivity.class)
                                         );
                        }
                    },700);
                }else{
                    Toast.makeText(log_in.this,"Login Failed",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("error",t.getLocalizedMessage());
                Toast.makeText(log_in.this,"error : "+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}