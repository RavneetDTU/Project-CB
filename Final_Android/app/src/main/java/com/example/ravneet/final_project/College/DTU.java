package com.example.ravneet.final_project.College;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ravneet.final_project.Adapter.BookAdapter;
import com.example.ravneet.final_project.BookPostActivity;
import com.example.ravneet.final_project.Interface.OnItemClickListner;
import com.example.ravneet.final_project.Model.Book;
import com.example.ravneet.final_project.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DTU extends AppCompatActivity {

    public static final String TAG = "false";

    RecyclerView rv_dtu;
    Button postAdd;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ChildEventListener childEventListener;

    BookAdapter bookAdapter;

    private OnItemClickListner onItemClickListner;



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
        databaseReference = firebaseDatabase.getReference();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Book thisbook = dataSnapshot.getValue(Book.class);
                String bkname = thisbook.getBookname();
                String sellername = thisbook.getSellername();
                String price = thisbook.getPrice();
                String mbnumber = thisbook.getMobilenumber();
                Log.d(TAG, "onChildAdded: "+bkname+sellername+price+mbnumber);



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseReference.addChildEventListener(childEventListener);

    }

}
