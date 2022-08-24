package com.muzammil.broadcastapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar accessing with id
        toolbar =findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        //back icon in toolbar is enabled (can be used in 2 activity)
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("Sub Title");


        Button btnNext;

        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent iNext;
                iNext = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(iNext);
            }
        });

        ImageView imageView = findViewById(R.id.imageView);
        Intent intent =getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type!=null){
            imageView.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM));
        }

    }

    //setting the menu
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid = item.getItemId();

        if (itemid==R.id.opt_new){
            Toast.makeText(this, "new file", Toast.LENGTH_SHORT).show();
        } else if (itemid==R.id.opt_open){
            Toast.makeText(this, "File open", Toast.LENGTH_SHORT).show();
        }
        else if (itemid ==android.R.id.home){
            super.onBackPressed();
        }
        else {
            Toast.makeText(this, "file Saved", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}