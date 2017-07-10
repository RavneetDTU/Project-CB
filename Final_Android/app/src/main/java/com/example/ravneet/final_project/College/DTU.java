package com.example.ravneet.final_project.College;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.final_project.BookPostActivity;
import com.example.ravneet.final_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DTU extends AppCompatActivity {

    RecyclerView rv_dtu;
    Button postAdd;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtu);

        postAdd = (Button) findViewById(R.id.btn_postadd_dtu);
        rv_dtu = (RecyclerView) findViewById(R.id.rv_dtu);

        postAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DTU.this, BookPostActivity.class);
                startActivity(i);
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://finalandroid-2774c.firebaseio.com/");
    }

}
