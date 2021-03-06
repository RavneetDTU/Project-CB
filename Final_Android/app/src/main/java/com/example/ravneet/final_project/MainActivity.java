package com.example.ravneet.final_project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ravneet.final_project.Activity.ContactUsActivity;
import com.example.ravneet.final_project.Activity.HowThisWorkActivity;
import com.example.ravneet.final_project.College.DTU;
import com.example.ravneet.final_project.College.IGDTUW;
import com.example.ravneet.final_project.College.IIIT_D;
import com.example.ravneet.final_project.College.NSIT;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MediaPlayer welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Thread mythread = new Thread(){
            @Override
            public void run() {
                welcome = MediaPlayer.create(MainActivity.this,R.raw.welcome);
                welcome.start();

            }
        };
        mythread.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.how_this_work) {
            startActivity(new Intent(MainActivity.this, HowThisWorkActivity.class));
            return true;
        }else if(id == R.id.user_agreemnet){
            return true;
        }else if(id == R.id.contact_us){
            startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dtu) {

            Intent i = new Intent(MainActivity.this, DTU.class);
            startActivity(i);

        } else if (id == R.id.nsit) {

            Intent i = new Intent(MainActivity.this, NSIT.class);
            startActivity(i);

        } else if (id == R.id.igdtuw) {
            Intent i = new Intent(MainActivity.this, IGDTUW.class);
            startActivity(i);

        }else if (id == R.id.iiit_d){

            Intent i = new Intent(MainActivity.this, IIIT_D.class);
            startActivity(i);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
