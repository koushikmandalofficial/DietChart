package com.app.dietchartfinal.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.activity.FoodDetailsActivity;
import com.app.dietchartfinal.model.FoodInformationModel;

import java.util.ArrayList;


public class DietAdaptor extends RecyclerView.Adapter<DietAdaptor.MyViewHolder> {

    ArrayList<String> personNames;
    ArrayList<Integer> personImages;
    Context context;
    ArrayList<FoodInformationModel> foodInformationModelArrayListBreakfast = new ArrayList<>();
    ArrayList<FoodInformationModel> suggestionListBrekfast;
    ArrayList<FoodInformationModel> foodInformationModelArrayListlunch = new ArrayList<>();
    ArrayList<FoodInformationModel> suggestionListlunch;
    ArrayList<FoodInformationModel> foodInformationModelArrayListDinner = new ArrayList<>();
    ArrayList<FoodInformationModel> suggestionListDinner;
    public DietAdaptor(Context context, ArrayList<String> personNames, ArrayList<Integer> personImages) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dailyrow, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        holder.image.setImageResource(personImages.get(position));



        SharedPreferences sh = context.getSharedPreferences("DietCharSharedPref", MODE_PRIVATE);

        if(Integer.parseInt(sh.getString("Age",""))<30) {

            //Breakfast data
            suggestionListBrekfast = new ArrayList<>();
            suggestionListBrekfast.add(new FoodInformationModel(2, R.drawable.banana, "Banana", "1.1 g",  "0.3 g",
                    "89", "22.8 g", context.getString(R.string.bananadetails), suggestionListBrekfast));
            foodInformationModelArrayListBreakfast = new ArrayList<>();
            foodInformationModelArrayListBreakfast.add(new FoodInformationModel(1, R.drawable.apple, "Apple",
                    "0.3 g",  "0.2 g", "52","13.8 g", context.getString(R.string.appeldetails), suggestionListBrekfast));


            //lunch data
            suggestionListlunch = new ArrayList<>();
            suggestionListlunch.add(new FoodInformationModel(2, R.drawable.fish, "Fish", "22 g",
                    "12 g", "206", "0 g", context.getString(R.string.fishDetails), suggestionListlunch));

            suggestionListlunch.add(new FoodInformationModel(2, R.drawable.rice, "Rice", "2.7 g", "3.2 g",
                    "130", "25 g", context.getString(R.string.riceDeteils), suggestionListlunch));
            foodInformationModelArrayListlunch = new ArrayList<>();
            foodInformationModelArrayListlunch.add(new FoodInformationModel(2, R.drawable.person2, "Chicken", "27 g", "3.6 g", "239", "0 g", context.getString(R.string.chickenDetails), suggestionListlunch));


            //Dinner data
            suggestionListDinner = new ArrayList<>();
            suggestionListDinner.add(new FoodInformationModel(2, R.drawable.bread, "Bread",
                    "9 g", "3.2 g", "100", "40 g", context.getString(R.string.breadDeteils), suggestionListDinner));

            foodInformationModelArrayListDinner = new ArrayList<>();
            foodInformationModelArrayListDinner.add(new FoodInformationModel(2, R.drawable.milk, "Milk",
                    "3.4 g", "1 g", "42", "5 g", context.getString(R.string.milkDetails), suggestionListDinner));
        }else {
            if(Integer.parseInt(sh.getString("Age",""))>30) {

                //Breakfast data
                suggestionListBrekfast = new ArrayList<>();
                suggestionListBrekfast.add(new FoodInformationModel(2, R.drawable.grapes,
                        "Grapes", "0.72 g",  "0.16 g", "72","18.1 g", context.getString(R.string.grapes), suggestionListBrekfast));

                foodInformationModelArrayListBreakfast = new ArrayList<>();
                foodInformationModelArrayListBreakfast.add(new FoodInformationModel(2, R.drawable.milk, "Milk", "3.4 g", "1 g", "42", "5 g", context.getString(R.string.milkDetails), suggestionListBrekfast));



                //lunch data
                suggestionListlunch = new ArrayList<>();
                suggestionListlunch.add(new FoodInformationModel(2, R.drawable.fish, "Fish", "22 g",
                        "12 g", "206", "0 g", context.getString(R.string.fishDetails), suggestionListlunch));

                suggestionListlunch.add(new FoodInformationModel(2, R.drawable.rice, "Rice", "2.7 g", "3.2 g",
                        "130", "25 g", context.getString(R.string.riceDeteils), suggestionListlunch));
                foodInformationModelArrayListlunch = new ArrayList<>();
                foodInformationModelArrayListlunch.add(new FoodInformationModel(2, R.drawable.person2, "Chicken", "27 g", "3.6 g", "239", "0 g", context.getString(R.string.chickenDetails), suggestionListlunch));


                //Dinner data
                suggestionListDinner = new ArrayList<>();
                suggestionListDinner.add(new FoodInformationModel(2, R.drawable.bread, "Bread",
                        "9 g", "3.2 g", "100", "40 g", context.getString(R.string.breadDeteils), suggestionListDinner));

                foodInformationModelArrayListDinner = new ArrayList<>();
                foodInformationModelArrayListDinner.add(new FoodInformationModel(2, R.drawable.milk, "Milk",
                        "3.4 g", "1 g", "42", "5 g", context.getString(R.string.milkDetails), suggestionListDinner));
            }
        }
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(personNames.get(position).equals("Breakefast")) {
                    // display food info
                    //  Toast.makeText(context, foodInformationModelArrayListBreakfast.get(0).toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, FoodDetailsActivity.class);
                    intent.putExtra("FoodDetails",foodInformationModelArrayListBreakfast.get(0));
                    context.startActivity(intent);
                }else if(personNames.get(position).equals("Lunch")) {
                    // display food info
                    //  Toast.makeText(context, foodInformationModelArrayListBreakfast.get(0).toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, FoodDetailsActivity.class);
                    intent.putExtra("FoodDetails",foodInformationModelArrayListlunch.get(0));
                    context.startActivity(intent);
                }else {
                    // display food info
                    //  Toast.makeText(context, foodInformationModelArrayListBreakfast.get(0).toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, FoodDetailsActivity.class);
                    intent.putExtra("FoodDetails",foodInformationModelArrayListDinner.get(0));
                    context.startActivity(intent);
                }
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
