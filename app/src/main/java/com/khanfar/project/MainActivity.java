package com.khanfar.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView MainName ;
private EditText name , username , email , address , phone ;
private Button changePassword , editInfo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setUpComponent () ;
        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editInfo.getText().equals("Edit Info")){
                    name.setEnabled(true);
                    username.setEnabled(true);
                    email.setEnabled(true);
                    address.setEnabled(true);
                    phone.setEnabled(true);
                    editInfo.setText("Save Info");
                }
                else {
                    Toast.makeText(MainActivity.this, "Data is Saved Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setUpComponent() {
        MainName = findViewById(R.id.MainName) ;
        name = findViewById(R.id.EditName) ;
        username = findViewById(R.id.EditUserName) ;
        email = findViewById(R.id.EditEmail) ;
        address = findViewById(R.id.EditAddress) ;
        phone = findViewById(R.id.EditPhone) ;
        changePassword = findViewById(R.id.changePassword) ;
        editInfo = findViewById(R.id.editInfo) ;

        name.setEnabled(false);
        username.setEnabled(false);
        email.setEnabled(false);
        address.setEnabled(false);
        phone.setEnabled(false);


    }
}