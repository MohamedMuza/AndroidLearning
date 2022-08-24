package com.muzammil.broadcastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent iPrevious;
        iPrevious = new Intent(MainActivity2.this, MainActivity.class);
        Button btnPre;
        btnPre = findViewById(R.id.btnPre);
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iPrevious);
            }
        });
    }

//        imageView = findViewById(R.id.torchView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

    public void torchApp(View view)
    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.muzammil.torch");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(MainActivity2.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }

    public void webClick(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com")));
    }
}
