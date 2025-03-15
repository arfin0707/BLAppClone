package com.stamasoftlab.java_bl_appclone.LoginDetails;



import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stamasoftlab.java_bl_appclone.LoggedInAllPages.MainActivity;
import com.stamasoftlab.java_bl_appclone.R;


public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Add in Oncreate() funtion after setContentView()*/
        SwitchCompat languageSwitch = (SwitchCompat) findViewById(R.id.languageSwitch); // initiate Switch
        SwitchCompat OtpSwitch = (SwitchCompat) findViewById(R.id.OtpSwitch); // initiate Switch
    //    FrameLayout frameLayout = findViewById(R.id.framelayout);

        // Initialize Views
        TextInputEditText mobile_no = findViewById(R.id.mobile_no);
        MaterialButton otpButton = findViewById(R.id.otpbtn);
        TextView errormsg = findViewById(R.id.errormsg);
       // errormsg.setVisibility(View.GONE);
        TextInputLayout passwordField = findViewById(R.id.passwordField);
        CheckBox checkBox_rememberPass = findViewById(R.id.checkBox_rememberPass);
        TextView ques_password = findViewById(R.id.ques_password);
        CheckBox checkBoxTerm = findViewById(R.id.checkBoxTerm);
        MaterialButton otpbtn = findViewById(R.id.otpbtn);
        MaterialButton loginBtn = findViewById(R.id.loginBtn);
        TextView registertext = findViewById(R.id.registertext);
        TextView register2 = findViewById(R.id.register2);


        // Add TextWatcher to accNo
        mobile_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();

                // Check if the input is valid (length = 11 and starts with "01")
                if (input.length() == 11 && input.startsWith("019") && checkBoxTerm.isChecked()) {
                    // Change button color to orange
                    errormsg.setVisibility(View.GONE);
                    otpButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange)); // Add orange to colors.xml
                    otpButton.setTextColor(getResources().getColorStateList(R.color.white));
                    otpButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(LoginPage.this, MainActivity.class);
                            startActivity(i);

                        }
                    });

                } else {
                    // If the input does not start with "01" or is invalid
                    if (!input.startsWith("019") && input.length() > 0) {
                        errormsg.setVisibility(View.VISIBLE);
                    }

/*                    // Reset button color to default
                    otpButton.setBackgroundTintList(getResources().getColorStateList(R.color.esh)); // Add gray to colors.xml
                    otpButton.setTextColor(getResources().getColorStateList(R.color.black)); // Optional: Reset text color*/
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });



        // Set an OnCheckedChangeListener
        OtpSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Handle `textOn` state (e.g., "Password")
                Toast.makeText(this, "Password Selected", Toast.LENGTH_SHORT).show();
/*                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout, new PasswordFragment());
                ft.commit();*/
                otpbtn.setVisibility(View.GONE);
                passwordField.setVisibility(View.VISIBLE);
                checkBox_rememberPass.setVisibility(View.VISIBLE);
                ques_password.setVisibility(View.VISIBLE);
                loginBtn.setVisibility(View.VISIBLE);
                registertext.setVisibility(View.VISIBLE);
                register2.setVisibility(View.VISIBLE);

                ques_password.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(LoginPage.this, ForgotPass.class);
                        startActivity(i);

                    }
                });

                register2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(LoginPage.this, resiterNow.class);
                        startActivity(i);

                    }
                });


            } else {
                // Handle `textOff` state (e.g., "OTP")
                Toast.makeText(this, "OTP Selected", Toast.LENGTH_SHORT).show();
/*                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout, new OtpFragment());
                ft.commit();*/
                otpbtn.setVisibility(View.VISIBLE);
                passwordField.setVisibility(View.GONE);
                checkBox_rememberPass.setVisibility(View.GONE);
                ques_password.setVisibility(View.GONE);
                loginBtn.setVisibility(View.GONE);
                registertext.setVisibility(View.GONE);
                register2.setVisibility(View.GONE);

            }
        });






    }
}