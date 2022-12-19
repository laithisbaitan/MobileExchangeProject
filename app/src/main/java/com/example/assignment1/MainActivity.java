package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button goToSignIn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Login");
        setContentView(R.layout.login);
        setUpComponent() ;
        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , sign_In_Activity.class ) ;
                startActivity(intent);
            }
        });
    }

    private void setUpComponent() {
        goToSignIn = findViewById(R.id.btnsignin);

    }
}