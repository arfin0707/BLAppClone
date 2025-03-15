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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.stamasoftlab.java_bl_appclone.HomeTab.PagerAdapter_HomeTab;
import com.stamasoftlab.java_bl_appclone.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.stamasoftlab.java_bl_appclone.RVoffers_CustomAdapter;
import com.stamasoftlab.java_bl_appclone.RVoffers_ModelClass;
import com.stamasoftlab.java_bl_appclone.LoggedInAllPages.SlideAdapter_forHome;


public class HomeFragment extends Fragment {
    private ViewPager viewPager1;
    private SlideAdapter_forHome slideAdapter_forHome;
    private LinearLayout dots;
    private TextView[] tv_dots;


    private Timer timer;
    private int currentPage = 0;
    private static final int AUTO_SCROLL_DELAY = 3000; // 3 seconds delay
    ArrayList<RVoffers_ModelClass> itemList;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_home, container, false);
       // super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
//-----------------------------------------------------------------------------------------------------------------------
        // Initialize ViewPager and Dots
        viewPager1 = root.findViewById(R.id.viewpager);
        dots = root.findViewById(R.id.dots);

        slideAdapter_forHome = new SlideAdapter_forHome(getActivity());
        viewPager1.setAdapter(slideAdapter_forHome);


        // Add dots initially and set listener
        adddots(0);
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

//------------------------------------------------------------------------------------------------------------------------

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("Top News"));
        tabLayout.addTab(tabLayout.newTab().setText("Economy"));
        tabLayout.addTab(tabLayout.newTab().setText("Bangladesh"));
        tabLayout.addTab(tabLayout.newTab().setText("World"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        // final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final ViewPager TabviewPager = (ViewPager) root.findViewById(R.id.pager);
        final PagerAdapter_HomeTab adapter1 = new PagerAdapter_HomeTab(getChildFragmentManager(), tabLayout.getTabCount());
        TabviewPager.setAdapter(adapter1);

        TabviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        //tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //   showViewPager(viewPager, navHostFragment); // Show ViewPager when a tab is selected
                TabviewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        //----------------------------------------------------------------------------------------------
        customizeColors();

        return root;
    }
    //-----------------------------------------------------------------------------------------------
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Your ViewPager, TabLayout, and other views initialization here
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
                    viewPager1.setCurrentItem(currentPage, true);
                });
            }
        }, AUTO_SCROLL_DELAY, AUTO_SCROLL_DELAY);
    }

    //-----------------------------------------------------------------------------------------------

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
                    ContextCompat.getColor(requireContext(), R.color.default_toolbar_color)
            );
        }

        // Safely update status bar color
        requireActivity().getWindow().setStatusBarColor(
                ContextCompat.getColor(requireContext(), R.color.default_toolbar_color)
        );
    }
    @Override
    public void onResume() {
        super.onResume();
        if (isVisible()) { // Ensure fragment is actually visible
            customizeColors();
        }
    }


    //-----------------------------------------------------------------------------------------------

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (timer != null) {
            timer.cancel();
            //timer = null;
        }
    }




//-----------------------------------------------------------------------------------------------

    private void initRecyclerView(){

        //initializing the productlist
        itemList = new ArrayList<>();
        itemList.add(
                new RVoffers_ModelClass(
                        1,
                        R.drawable.img4,
                        "Play Games",
                        "Explore➔")
        );
        itemList.add(
                new RVoffers_ModelClass(
                        2,
                        R.drawable.img7,
                        "Pay Bill|Tickets",
                        "Explore➔")
        );
        itemList.add(
                new RVoffers_ModelClass(
                        3,
                        R.drawable.img2,
                        "Care",
                        "Explore➔")
        );
        itemList.add(
                new RVoffers_ModelClass(
                        4,
                        R.drawable.img3,
                        "Courses",
                        "Explore➔")
        );


        //List Vertical
        RecyclerView recyclerView =(RecyclerView) root.findViewById(R.id.rv_offers);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RVoffers_CustomAdapter adapter = new RVoffers_CustomAdapter(getActivity(),itemList);
        // adapter.setClickListener(this); // Set the click listener
        recyclerView.setAdapter(adapter);


    }



}