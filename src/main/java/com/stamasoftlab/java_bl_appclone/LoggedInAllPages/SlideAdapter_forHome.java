package com.stamasoftlab.java_bl_appclone.LoggedInAllPages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.stamasoftlab.java_bl_appclone.R;


public class SlideAdapter_forHome extends PagerAdapter {

    public SlideAdapter_forHome(Context context) {
        this.context = context;
    }

    private Context context;
    private int[] slider_images= {
          R.drawable.home_slide_item1,
          R.drawable.home_slide_item2,
          R.drawable.home_slide_item3,
          R.drawable.home_slide_item4,
          R.drawable.home_slide_item5,
          R.drawable.home_slide_item6
    };
    @Override
    public int getCount() {
        return slider_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layourinflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layourinflater.inflate(R.layout.activity_slide_layout_for_home,container,false);
//
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // Fixed capitalization
//        View view = layoutInflater.inflate(R.layout.activity_slide_layout, container, false); // Corrected parentheses

        ImageView imageLayout =view.findViewById(R.id.imageLayout);
        imageLayout.setImageResource(slider_images[position]);


        container.addView(view);
        return view;
       // return super.instantiateItem(container, position);
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
