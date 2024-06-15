package com.app.dietchartfinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.dietchartfinal.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<Integer> userList;

    public FoodAdapter(List<Integer> userList){this.userList=userList;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(userList.get(position));
        holder.imageView.setImageResource(userList.get(position));

    //nt res=userList.get(position).getImgFood()
       // String name=userList.get(position).getTvFood();

     //   holder.setData(res,name);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgFood);
            textView = itemView.findViewById(R.id.tvFood);
        }

        public void setData(int res, String name) {

            imageView.setImageResource(res);
            textView.setText(name);
        }
    }
}