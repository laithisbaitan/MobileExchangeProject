package com.example.mobileexchangeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    //bot nav
    BottomNavigationView bottomNavigationView;

    //side nav
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    //recycler
    RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.backpack,R.drawable.cup,R.drawable.chair,R.drawable.laptop};

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
        setContentView(R.layout.activity_home);

        recyclerViewSetup();
        actionBarSettings();
        sideNav();
        botNav();
    }

    // ***********Recycler View********
    public void recyclerViewSetup(){
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.items_in_recycler);
        s2 = getResources().getStringArray(R.array.descriptiom);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // ************Action Bar***********
    public void actionBarSettings(){
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle("Username");

        // adding icon in the ActionBar
        actionBar.setIcon(R.drawable.ic_logo);

        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    // *************Side Nav*************
    public void sideNav(){
        drawerLayout = findViewById(R.id.home_drawer);
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
                    case R.id.add_item:{
                        Toast.makeText(Home.this,"add item page",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),AddItem.class));
                        overridePendingTransition(0,0);
                        break;
                    }
                    case R.id.home:{
                        Toast.makeText(Home.this,"you are already here",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    case R.id.favorite: {
                        Toast.makeText(Home.this, "favorite page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Favorite.class));
                        overridePendingTransition(0,0);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // *************Bot Nav**************
    public void botNav(){
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        Toast.makeText(Home.this, "add item page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),AddItem.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.favorite:
                        Toast.makeText(Home.this, "favorite page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Favorite.class));
                        overridePendingTransition(0,0);
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