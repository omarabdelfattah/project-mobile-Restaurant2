package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Product extends AppCompatActivity
{
    ImageView iv;
    TextView tv,tv_dis,price;
    Meil m;

    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product);

        iv=findViewById(R.id.iv2);
        tv=findViewById(R.id.tv2);
        tv_dis=findViewById(R.id.tv_dis);
        price=findViewById(R.id.price);
        m = new Meil();
        m = (Meil) getIntent().getSerializableExtra("data");
        iv.setImageResource(m.getImg());
        tv.setText(m.getName());
        tv_dis.setText(m.getDis());
        price.setText(m.getPrice());
        np =findViewById(R.id.numberPicker);
        np.setMinValue(1);
        np.setMaxValue(100);
    }

    public void added(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        Toast.makeText(this, "Meal added!!!🍔", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void back(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}