package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sign_In_Activity extends AppCompatActivity {

    private Button signInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sign In");

        setContentView(R.layout.signin);

        setUpComponent();
        }

    private void setUpComponent(){
        signInBtn = findViewById(R.id.btnsignin);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Home.class));
                overridePendingTransition(0,0);
            }
        });
    }
}
