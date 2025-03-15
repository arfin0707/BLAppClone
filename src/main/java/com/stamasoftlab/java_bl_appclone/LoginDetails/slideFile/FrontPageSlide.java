package com.stamasoftlab.java_bl_appclone.LoginDetails.slideFile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.stamasoftlab.java_bl_appclone.LoginDetails.LoginPage;
import com.stamasoftlab.java_bl_appclone.GuestAllPages.MainActivity2;
import com.stamasoftlab.java_bl_appclone.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrontPageSlide extends AppCompatActivity {
/*
    ViewFlipper simpleViewFlipper;
    Button btnNext;
    ImageView b_1, b_2, b_3, b_4, b_5;
*/


    private ViewPager viewPager;
    private SlideAdapter slideAdapter;
    private LinearLayout dots;
    private TextView[] tv_dots;


    private Timer timer;
    private int currentPage = 0;
    private static final int AUTO_SCROLL_DELAY = 3000; // 3 seconds delay


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front_page_slide);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Initialize ViewPager and Dots
        viewPager = findViewById(R.id.viewpager);
        dots = findViewById(R.id.dots);

        slideAdapter = new SlideAdapter(FrontPageSlide.this);
        viewPager.setAdapter(slideAdapter);


        // Add dots initially and set listener
        adddots(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Not needed for now
            }

            @Override
            public void onPageSelected(int position) {
                // Add dots for the selected page
                adddots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Not needed for now
            }
        });
        // Setup auto-scroll
        setupAutoScroll();

        MaterialButton btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPageSlide.this, LoginPage.class);
                startActivity(i);

            }
        });
        MaterialButton btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontPageSlide.this, MainActivity2.class);
                startActivity(i);

            }
        });


    }

    private void adddots(int position) {
        // Clear previous dots
        dots.removeAllViews();

        // Initialize the dots array
        tv_dots = new TextView[6];

        for (int i = 0; i < tv_dots.length; i++) {
            tv_dots[i] = new TextView(FrontPageSlide.this);
            tv_dots[i].setText(Html.fromHtml("&#8226;")); // Dot character
            tv_dots[i].setTextSize(35);
            tv_dots[i].setTextColor(getResources().getColor(R.color.esh)); // Default color
            // Add each dot to the LinearLayout
            dots.addView(tv_dots[i]);
        }

        // Highlight the selected dot
        if (tv_dots.length > 0) {
            tv_dots[position].setTextColor(getResources().getColor(R.color.orange)); // Highlighted color
        }
    }


    private void setupAutoScroll() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    // Move to the next page
                    if (currentPage == slideAdapter.getCount() - 1) {
                        currentPage = 0; // If last page, go back to the first page
                    } else {
                        currentPage++;
                    }
                    viewPager.setCurrentItem(currentPage, true);
                });
            }
        }, AUTO_SCROLL_DELAY, AUTO_SCROLL_DELAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel timer to avoid memory leaks
        if (timer != null) {
            timer.cancel();
        }
    }
}
