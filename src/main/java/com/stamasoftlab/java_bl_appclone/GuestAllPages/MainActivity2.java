package com.stamasoftlab.java_bl_appclone.GuestAllPages;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.stamasoftlab.java_bl_appclone.R;

public class MainActivity2 extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Set up the toolbar as the action bar
        Toolbar toolbar2 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar2);

        // Set custom layout for the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setCustomView(R.layout.activity_custom_action_bar);
        }

        // Access elements in the custom action bar
        View customView = getSupportActionBar().getCustomView();
        TextView customTitle = customView.findViewById(R.id.custom_title);
        ImageView custom_logo = customView.findViewById(R.id.custom_logo);

        // Set an OnClickListener for the action button if needed
        custom_logo.setOnClickListener(v -> {
            // Handle action button click
            Toast.makeText(this, "Action button clicked!", Toast.LENGTH_SHORT).show();
        });

/*
        Fragment selectedFragment = null;
*/

        DrawerLayout drawer_layout2 = findViewById(R.id.drawer_layout2);
        NavigationView drawer_nav_view2 = findViewById(R.id.drawer_nav_view2);
        BottomNavigationView nav_bottom_view2 = findViewById(R.id.nav_bottom_view2);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
         mAppBarConfiguration2 = new AppBarConfiguration.Builder(
                R.id.navigation_guest, R.id.navigation_content2, R.id.navigation_commerce2,R.id.navigation_courses2,R.id.navigation_care2)
                .setOpenableLayout(drawer_layout2)
                .build();
        //  Navigation nav_view =findViewById(R.id.nav_view);
        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        NavigationUI.setupActionBarWithNavController(this, navController2, mAppBarConfiguration2);
        NavigationUI.setupWithNavController(drawer_nav_view2, navController2);

        // BottomNavigationView setup
        NavigationUI.setupWithNavController(nav_bottom_view2, navController2);



    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController2, mAppBarConfiguration2)
                || super.onSupportNavigateUp();
    }
}