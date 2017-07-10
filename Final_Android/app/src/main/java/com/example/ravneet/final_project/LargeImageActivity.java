package com.example.ravneet.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LargeImageActivity extends AppCompatActivity {

    ImageView bookimage;
    TextView sellername,bookname,currentyear,mobilenumber,description,email,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);

        bookimage = (ImageView) findViewById(R.id.iv_book);
        sellername = (TextView) findViewById(R.id.tv_seller);
        bookname = (TextView) findViewById(R.id.tv_bookname);
        currentyear = (TextView) findViewById(R.id.tv_studingyear);
        mobilenumber = (TextView) findViewById(R.id.tv_mobilenumber);
        description = (TextView) findViewById(R.id.tv_description);
        email = (TextView) findViewById(R.id.tv_email);
        price = (TextView) findViewById(R.id.tv_price);
    }
}
