package com.app.dietchartfinal.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.activity.FoodDetailsActivity;
import com.app.dietchartfinal.activity.HomeActivity;
import com.app.dietchartfinal.model.FoodInformationModel;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<FoodInformationModel> personNames;
    ArrayList<Integer> personImages;
    Context context;

   /* public CustomAdapter(Context context, ArrayList<String> personNames, ArrayList<Integer> personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }*/

    public CustomAdapter(Context context, ArrayList<FoodInformationModel> foodInformationModelArrayList) {
        this.context = context;
        this.personNames = foodInformationModelArrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position).getName());
        holder.image.setImageResource(personNames.get(position).getFoodImg());
        // implement setOnClickListener event on item view.

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, personNames.get(position).getDetails(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, FoodDetailsActivity.class);
                intent.putExtra("FoodDetails", personNames.get(position));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
