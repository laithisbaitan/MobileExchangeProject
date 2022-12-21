package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MyProfile extends AppCompatActivity {
private TextView MainName ;
private EditText name , username , email , address , phone ;
private ImageView imageView ;
private Button changePassword , editInfo ;
private AlertDialog.Builder builder ;
private  AlertDialog alertDialog ;
private EditText oldPassword , newPassword , confirmPassword ;
private  Button cancel , savePassword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Profile");
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
                    Toast.makeText(MyProfile.this, "Data is Saved Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPasswordForm() ;

            }
        });
    }

    private void createPasswordForm() {
        builder = new AlertDialog.Builder(this) ;
        final View passwordPopUp = getLayoutInflater().inflate(R.layout.popup_create_password, null) ;
        oldPassword = passwordPopUp.findViewById(R.id.oldPassword) ;
        newPassword  = passwordPopUp.findViewById(R.id.newPassword) ;
        confirmPassword = passwordPopUp.findViewById(R.id.confirmPassword) ;
       // cancel = passwordPopUp.findViewById(R.id.cancel) ;
        savePassword = passwordPopUp.findViewById(R.id.savePassword) ;
        builder.setView(passwordPopUp);
         alertDialog = builder.create() ;
         alertDialog.show();

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
        imageView = findViewById(R.id.profileImage);

        name.setText("Tareq khanfar");
        username.setText("tareq_99912");
        phone.setText("0595870228");
        email.setText("tareqkhanfar29@gmail.com");
        address.setText("Ramallah - Birzeit");
        imageView.setImageResource(R.drawable.profile_pic);

        name.setEnabled(false);
        username.setEnabled(false);
        email.setEnabled(false);
        address.setEnabled(false);
        phone.setEnabled(false);

    }
}