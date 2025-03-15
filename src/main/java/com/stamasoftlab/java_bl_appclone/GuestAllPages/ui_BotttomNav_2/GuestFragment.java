package com.stamasoftlab.java_bl_appclone.GuestAllPages.ui_BotttomNav_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stamasoftlab.java_bl_appclone.R;
import com.stamasoftlab.java_bl_appclone.RVoffers_CustomAdapter;
import com.stamasoftlab.java_bl_appclone.RVoffers_ModelClass;

import java.util.ArrayList;


public class GuestFragment extends Fragment {
    ArrayList<RVoffers_ModelClass> itemList;
    View root;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root= inflater.inflate(R.layout.fragment_guest, container, false);
        initRecyclerView();
        customizeColors();
        return root;
    }



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

        customizeColors();

    }

    private void customizeColors() {
        if (getActivity() == null) {
            return; // Avoid null pointer exceptions during transitions
        }

        // Safely update toolbar color
        View toolbar = requireActivity().findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setBackgroundColor(
                    ContextCompat.getColor(requireContext(), R.color.yellow)
            );
        }

        // Safely update status bar color
        requireActivity().getWindow().setStatusBarColor(
                ContextCompat.getColor(requireContext(), R.color.yellow)
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
/*        if (timer != null) {
            timer.cancel();
            //timer = null;
        }*/
    }

}