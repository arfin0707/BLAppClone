package com.stamasoftlab.java_bl_appclone.GuestAllPages.ui_BotttomNav_2;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stamasoftlab.java_bl_appclone.R;

public class CoursesFragment2 extends Fragment {
    View root;
    BottomNavigationView bottomNavigationView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_courses2, container, false);

        bottomNavigationView2 = requireActivity().findViewById(R.id.nav_bottom_view2);
        customizeColors();
        return root;
    }



    //----------------------------------------------------------

    private void customizeColors() {
        if (getActivity() == null) {
            return; // Avoid null pointer exceptions during transitions
        }

        // Safely update toolbar color
        View toolbar = requireActivity().findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setBackgroundColor(
                  //  ContextCompat.getColor(requireContext(), R.color.courses_toolbar_color)
                    ContextCompat.getColor(requireContext(), R.color.yellow)
            );
        }

        // Safely update status bar color
        requireActivity().getWindow().setStatusBarColor(
              //  ContextCompat.getColor(requireContext(), R.color.courses_toolbar_color)
                ContextCompat.getColor(requireContext(), R.color.yellow)
        );

/*        // Change navigation bar color (optional)
        requireActivity().getWindow().setNavigationBarColor(
                getResources().getColor(R.color.white)
        );*/

        updateSelectedNavigationItem(bottomNavigationView2, R.id.navigation_courses2);
    }

    private void updateSelectedNavigationItem(BottomNavigationView bottomNavigationView, int selectedItemId) {
        // Update the background for all items
        for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
            int menuItemId = bottomNavigationView.getMenu().getItem(i).getItemId();
            View itemView = bottomNavigationView.findViewById(menuItemId);

            if (itemView != null) {
                // Apply green background for the selected item
                if (menuItemId == selectedItemId) {
                    itemView.setBackgroundResource(R.drawable.a_rounded_background_violet);
                } else {
                    // Reset other items to their default background
                    itemView.setBackgroundResource(R.drawable.a_bottom_nav_item_background_yellow);
                }
            }
        }
    }

    private void resetNavigationItemToDefault(BottomNavigationView bottomNavigationView, int menuItemId) {
        View itemView = bottomNavigationView.findViewById(menuItemId);
        if (itemView != null) {
            // Reset the item to its default background
            itemView.setBackgroundResource(R.drawable.a_bottom_nav_item_background_yellow);
        }

    }

/*    @Override
    public void onPause() {
        super.onPause();
        if (timer != null) {
            timer.cancel();
        }
    }*/

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
/*        if (timer != null) {
            timer.cancel();
        }*/
        resetNavigationItemToDefault(bottomNavigationView2, R.id.navigation_courses2);
    }


}