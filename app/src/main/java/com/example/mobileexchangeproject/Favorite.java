package com.example.mobileexchangeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Favorite extends AppCompatActivity {

    //bot nav
    BottomNavigationView bottomNavigationView;

    //side nav
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        actionBarSettings();
        sideNav();
        botNav();

    }

    private void actionBarSettings() {
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle("Username");

        // adding icon in the ActionBar
        actionBar.setIcon(R.drawable.ic_logo);

        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources()
                        .getColor(R.color.teal_700)));
        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    // *************Side Nav*************
    public void sideNav(){
        drawerLayout = findViewById(R.id.favorite_drawer);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout
                ,R.string.open
                ,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:{
                        Toast.makeText(Favorite.this,"Profile page",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),AddItem.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.home:{
                        Toast.makeText(Favorite.this,"Home page",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.myItems: {
                        Toast.makeText(Favorite.this, "My Items page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.notification: {
                        Toast.makeText(Favorite.this, "Notification page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.favorite: {
                        Toast.makeText(Favorite.this, "you are here page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.add_item: {
                        Toast.makeText(Favorite.this, "Add Item page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),AddItem.class));
                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.settings: {
                        Toast.makeText(Favorite.this, "Settings page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // *************Bot Nav**************
    private void botNav() {
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.favorite);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        startActivity(new Intent(getApplicationContext(), AddItem.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.favorite:
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}