package com.example.assignment1;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerViewSetup();
        actionBarSettings();
        sideNav();
        botNav();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStop() {
        //1- save favorite items

        //2- logout user
        super.onStop();
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

        getSupportActionBar().setBackgroundDrawable(
                                new ColorDrawable(getResources()
                                .getColor(R.color.teal_700)));

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
                    case R.id.profile:{
                        Toast.makeText(Home.this,"Profile page",Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),AddItem.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.home:{
                        Toast.makeText(Home.this,"you are already here",Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    case R.id.myItems: {
                        Toast.makeText(Home.this, "My Items page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.notification: {
                        Toast.makeText(Home.this, "Notification page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),Favorite.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.favorite: {
                        Toast.makeText(Home.this, "favorite page", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Favorite.class));
                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.add_item: {
                        Toast.makeText(Home.this, "Add Item page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),AddItem.class));
//                        overridePendingTransition(0,0);
                        return true;
                    }
                    case R.id.settings: {
                        Toast.makeText(Home.this, "Settings page", Toast.LENGTH_SHORT).show();
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
    public void botNav(){
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add_item:
                        Toast.makeText(Home.this, "add item page", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),AddItem.class));
//                        overridePendingTransition(0,0);
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