package com.salmaabdulhai.khadok;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.salmaabdulhai.khadok.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ActivityMainBinding binding;
    private DrawerLayout drawer;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        //to handle the click events for the menu in the navigation drawer, we need to
        //first reference the nav view
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_header_mobileId);
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String mobileNumber = preferences.getString("mobileUser", "");
        navUsername.setText(mobileNumber);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // when the activity starts a fragment i.e the first option
        //in the menu should be already selected, therefore

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.Home);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        //else, if the drawer is not open and the hard back key is pressed,
        //the onclick back button will close the activity.

        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

       //return to means no item will be selected but we want it to be selected after we click it.
        //therefore true.

        switch (item.getItemId()) {
            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Home_Fragment()).commit();
                break;

            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Chef_reg_Frag()).commit();
                break;

                case R.id.nav_myOrders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CustomerOrderFragment()).commit();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

   public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.myorder_menu, menu);
        return super.onCreateOptionsMenu(menu);
   }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.my_orders:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CustomerOrderFragment()).commit();
               
               NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.setCheckedItem(R.id.nav_myOrders);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

