package com.example.ravneet.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.final_project.Model.Book;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class BookPostActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    EditText et_bookname,et_yourname,et_email,et_mobileno,et_description,et_college_year,et_price;
    Button btn_post,btn_addimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_post);

        et_bookname = (EditText) findViewById(R.id.et_bookname);
        et_yourname = (EditText) findViewById(R.id.et_yourname);
        et_email = (EditText) findViewById(R.id.et_email);
        et_mobileno = (EditText) findViewById(R.id.et_mobileno);
        et_description = (EditText) findViewById(R.id.et_description);
        et_college_year = (EditText) findViewById(R.id.et_college);
        et_price = (EditText) findViewById(R.id.et_bookprice);

        btn_post = (Button) findViewById(R.id.btn_finalpost);
        btn_addimage = (Button) findViewById(R.id.btn_addimage);


        databaseReference = FirebaseDatabase.getInstance().getReference();

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savebookdata();
                Toast.makeText(getApplicationContext(),"Posting Your ADD....",Toast.LENGTH_LONG).show();
            }
        });



    }

    private void savebookdata(){

        String bookname = et_bookname.getText().toString().trim();
        String sellername = et_yourname.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String mobileNo = et_mobileno.getText().toString().trim();
        String description = et_description.getText().toString().trim();
        String collegeAndYear = et_college_year.getText().toString().trim();
        String price = et_price.getText().toString().toString().trim();

        Book bookadd = new Book(bookname,sellername,mobileNo,price,description,collegeAndYear,email);

        databaseReference.child("Data").setValue(bookadd);
    }
}
