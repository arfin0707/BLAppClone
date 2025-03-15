package com.stamasoftlab.java_bl_appclone.HomeTab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapter_HomeTab extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public PagerAdapter_HomeTab(FragmentManager fm, int mNumOfTabs) {
       // super(fm);
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mNumOfTabs = mNumOfTabs;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TopNewsFragment tab1 = new TopNewsFragment();
                return tab1;
            case 1:
                EconomyFragment tab2 = new EconomyFragment();
                return tab2;
            case 2:
                BangladeshFragment tab3 = new BangladeshFragment();
                return tab3;
            case 3:
                WorldFragment tab4 = new WorldFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
