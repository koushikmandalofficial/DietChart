package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.adapter.CustomAdapter;
import com.app.dietchartfinal.model.FoodInformationModel;

import java.util.ArrayList;
import java.util.Arrays;

public class FoodDetailsActivity extends AppCompatActivity {
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable","Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7,R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7));
    ArrayList<FoodInformationModel> foodInformationModelArrayList = new ArrayList<>();
    ArrayList<FoodInformationModel.Suggestion> suggestionList= new ArrayList<>();
    FoodInformationModel foodInformationModel;
    ImageView ivFood;
    RecyclerView recyclerView;
    TextView tvDetails,foodname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView =findViewById(R.id.recyclerView);
        ImageView back  =findViewById(R.id.back);
        ivFood  =findViewById(R.id.ivFood);
        tvDetails  =findViewById(R.id.tvDetails);
        foodname  =findViewById(R.id.foodname);



        setdatatoUI();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FoodDetailsActivity.this, DietInformationActivity.class);
                startActivity(intent1);
            }
        });

    }

    private void setdatatoUI() {
        foodInformationModel=new FoodInformationModel();
        foodInformationModel=(FoodInformationModel) getIntent().getSerializableExtra("FoodDetails");
       try {
           ivFood.setImageResource(foodInformationModel.getFoodImg());
           tvDetails.setText(foodInformationModel.getDetails());
           foodname.setText("This is "+foodInformationModel.getName()+" !");
           setAdapter();
       }catch (Exception e){
           
       }


    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(FoodDetailsActivity.this, foodInformationModel.getSuggestionList());
        recyclerView.setAdapter(customAdapter);
    }
}