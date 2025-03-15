package com.stamasoftlab.java_bl_appclone.LoginDetails;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.stamasoftlab.java_bl_appclone.R;

public class resiterNow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resiter_now);
/*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
*/


        // Initialize Views
        TextInputEditText mobile_no =findViewById(R.id.mobile_no);
        MaterialButton otpButton = findViewById(R.id.otpbtn);
        TextView errormsg = findViewById(R.id.errormsg);
        errormsg.setVisibility(View.GONE);


        // Add TextWatcher to accNo
        mobile_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();

                // Check if the input is valid (length = 11 and starts with "01")
                if (input.length() == 11 && input.startsWith("01")) {
                    // Change button color to orange
                    otpButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange)); // Add orange to colors.xml
                    otpButton.setTextColor(getResources().getColorStateList(R.color.white));
                } else {
                    // If the input does not start with "01" or is invalid
                    if (!input.startsWith("01") && input.length() > 0) {
                        errormsg.setVisibility(View.VISIBLE);
                    }

                    // Reset button color to default
                    otpButton.setBackgroundTintList(getResources().getColorStateList(R.color.esh)); // Add gray to colors.xml
                    otpButton.setTextColor(getResources().getColorStateList(R.color.black)); // Optional: Reset text color
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        TextView backtologin =findViewById(R.id.backtologin);
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(resiterNow.this, LoginPage.class);
                startActivity(i);

            }
        });

    }
}