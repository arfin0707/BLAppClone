package com.stamasoftlab.java_bl_appclone.LoginDetails.slideFile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.stamasoftlab.java_bl_appclone.R;


public class SlideAdapter extends PagerAdapter {

    public SlideAdapter(Context context) {
        this.context = context;
    }

    private Context context;
    private int[] slider_images= {
          R.drawable.img1,
          R.drawable.img2,
          R.drawable.img3,
          R.drawable.img4,
          R.drawable.img5,
          R.drawable.img6
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
        View view =layourinflater.inflate(R.layout.activity_slide_layout,container,false);
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
