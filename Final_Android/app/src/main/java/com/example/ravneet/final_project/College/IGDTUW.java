package com.example.ravneet.final_project.College;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.final_project.BookPostActivity;
import com.example.ravneet.final_project.R;

public class IGDTUW extends AppCompatActivity {

    Button postAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igdtuw);

        postAdd = (Button) findViewById(R.id.btn_postadd_igdtuw);

        postAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(IGDTUW.this, BookPostActivity.class);
                startActivity(i);
            }
        });
    }
}
