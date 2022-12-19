package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {

    private Animation top, buttom;
private ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.logopage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.logo1);
        top = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        buttom = AnimationUtils.loadAnimation(this, R.anim.buttom_animation);

        imageView.setAnimation(top);
        imageView.setAnimation(buttom);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        } ,5000);

    }
}
