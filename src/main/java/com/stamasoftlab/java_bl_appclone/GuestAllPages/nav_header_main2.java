package com.stamasoftlab.java_bl_appclone.GuestAllPages;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.stamasoftlab.java_bl_appclone.R;


public class nav_header_main2 extends AppCompatActivity {
    String[] item = {"Guest","User"};
    Spinner sp;
  //  String[] item = {"Guest", "User"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main2);

        //spinner
/*        sp=findViewById(R.id.sp);
        ArrayAdapter<String> adapterPP =new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,Login);
        sp.setAdapter(adapterPP);
        sp.setSelection(0);*/
        //spinner
/*        sp=findViewById(R.id.sp);
        ArrayAdapter<String> adapter1 =new ArrayAdapter<>(nav_header_main2.this, android.R.layout.simple_spinner_item,item);
       // adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Important!

        sp.setAdapter(adapter1);*/


        sp = findViewById(R.id.sp);

// Create the ArrayAdapter with the item list and the default layout for the spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(nav_header_main2.this, android.R.layout.simple_spinner_item, item);

// Set the layout for the dropdown items in the spinner
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Set the adapter to the Spinner
        sp.setAdapter(adapter1);

    }

}
