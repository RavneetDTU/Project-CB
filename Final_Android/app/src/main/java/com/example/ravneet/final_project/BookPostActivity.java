package com.example.ravneet.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class BookPostActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListner;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mStorageReference;

    EditText bookname,yourname,email,mobileno,description,college_year;
    Button post,addimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_post);

        bookname = (EditText) findViewById(R.id.et_bookname);
        yourname = (EditText) findViewById(R.id.et_yourname);
        email = (EditText) findViewById(R.id.et_email);
        mobileno = (EditText) findViewById(R.id.et_mobileno);
        description = (EditText) findViewById(R.id.et_description);
        college_year = (EditText) findViewById(R.id.et_college);

        post = (Button) findViewById(R.id.btn_finalpost);
        addimage = (Button) findViewById(R.id.btn_addimage);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseStorage = FirebaseStorage.getInstance();

        mDatabaseReference = mFirebaseDatabase.getReference().child("");
        mStorageReference = mFirebaseStorage.getReference().child("");
    }
}
