package com.stamasoftlab.java_bl_appclone.LoggedInAllPages.ui_BotttomNav_1;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stamasoftlab.java_bl_appclone.LoggedInAllPages.SlideAdapter_forHome;
import com.stamasoftlab.java_bl_appclone.R;

import java.util.Timer;
import java.util.TimerTask;


public class ContentFragment extends Fragment {

    View root;
    private ViewPager viewPager;
    private SlideAdapter_forHome slideAdapter_forHome;
    private LinearLayout dots;
    private TextView[] tv_dots;
    private Timer timer;
    private int currentPage = 0;
    private static final int AUTO_SCROLL_DELAY = 3000; // 3 seconds delay
    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_content, container, false);


        // Initialize ViewPager and Dots
        viewPager = root.findViewById(R.id.viewpager);
        dots = root.findViewById(R.id.dots);

        slideAdapter_forHome = new SlideAdapter_forHome(getActivity());
        viewPager.setAdapter(slideAdapter_forHome);


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

         bottomNavigationView = requireActivity().findViewById(R.id.nav_bottom_view);

        customizeColors();



        return root;
    }


    private void adddots(int position) {
        // Clear previous dots
        dots.removeAllViews();

        // Initialize the dots array
        tv_dots = new TextView[6];

        for (int i = 0; i < tv_dots.length; i++) {
            tv_dots[i] = new TextView(getActivity());
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
                getActivity().runOnUiThread(() -> {
                    // Move to the next page
                    if (currentPage == slideAdapter_forHome.getCount() - 1) {
                        currentPage = 0; // If last page, go back to the first page
                    } else {
                        currentPage++;
                    }
                    viewPager.setCurrentItem(currentPage, true);
                });
            }
        }, AUTO_SCROLL_DELAY, AUTO_SCROLL_DELAY);
    }

    /*    @Override
        public void onDestroyView() {
            super.onDestroyView();
            // Cancel timer to avoid memory leaks
            if (timer != null) {
                timer.cancel();
            }
        }*/


    private void customizeColors() {
        if (getActivity() == null) {
            return; // Avoid null pointer exceptions during transitions
        }

        // Safely update toolbar color
        View toolbar = requireActivity().findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setBackgroundColor(
                    ContextCompat.getColor(requireContext(), R.color.content_toolbar_color)
            );
        }

        // Safely update status bar color
        requireActivity().getWindow().setStatusBarColor(
                ContextCompat.getColor(requireContext(), R.color.content_toolbar_color)
        );
/*        // Change navigation bar color (optional)
        requireActivity().getWindow().setNavigationBarColor(
                getResources().getColor(R.color.white)


        );*/
        updateSelectedNavigationItem(bottomNavigationView, R.id.navigation_content);
    }

    private void updateSelectedNavigationItem(BottomNavigationView bottomNavigationView, int selectedItemId) {
        // Update the background for all items
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            int menuItemId = bottomNavigationView.getMenu().getItem(i).getItemId();
            View itemView = bottomNavigationView.findViewById(menuItemId);

            if (itemView != null) {
                // Apply green background for the selected item
                if (menuItemId == selectedItemId) {
                    itemView.setBackgroundResource(R.drawable.a_rounded_background_content);
                } else {
                    // Reset other items to their default background
                    itemView.setBackgroundResource(R.drawable.a_bottom_nav_item_background_orange);
                }
            }
        }
    }

    private void resetNavigationItemToDefault(BottomNavigationView bottomNavigationView, int menuItemId) {
        View itemView = bottomNavigationView.findViewById(menuItemId);
        if (itemView != null) {
            // Reset the item to its default background
            itemView.setBackgroundResource(R.drawable.a_bottom_nav_item_background_orange);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            customizeColors();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (timer != null) {
            timer.cancel();
        }
        resetNavigationItemToDefault(bottomNavigationView, R.id.navigation_content);
    }



}