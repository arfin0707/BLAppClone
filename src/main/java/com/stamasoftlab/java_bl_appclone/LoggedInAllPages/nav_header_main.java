package com.stamasoftlab.java_bl_appclone.LoggedInAllPages;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.stamasoftlab.java_bl_appclone.R;


public class nav_header_main extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] item = {"Guest","User"};
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);

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


/*        sp = findViewById(R.id.sp);

// Create the ArrayAdapter with the item list and the default layout for the spinner
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(nav_header_main.this, android.R.layout.simple_spinner_item, item);

// Set the layout for the dropdown items in the spinner
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Set the adapter to the Spinner
        sp.setAdapter(adapter1);*/



        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.sp);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,item);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);




    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),item[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
