package com.stamasoftlab.java_bl_appclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class RVoffers_CustomAdapter extends RecyclerView.Adapter<RVoffers_CustomAdapter.ViewHolder> {

    public RVoffers_CustomAdapter(Context mContext, ArrayList<RVoffers_ModelClass> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    private Context mContext;
    private ArrayList<RVoffers_ModelClass> itemList;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout_offers, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //getting the product of the specified position
        RVoffers_ModelClass item = itemList.get(position);  //position


/*        Glide.with(mContext)
                .asBitmap()
                .load(item.getMimageView_top())
                .error(R.drawable.ic_launcher_background)  // Provide a default image in case of error
                .into(holder.imageView_top);*/
       // holder.imageView_top.setImageResource(item.get(position));
        holder.imageView_top.setImageResource(item.getMimageView_top());
        holder.title.setText(item.getMtitle());
        holder.btn.setText(item.getMbtn());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_top;
        TextView title;
        MaterialButton btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_top = itemView.findViewById(R.id.imageView_top);
            title = itemView.findViewById(R.id.title);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
