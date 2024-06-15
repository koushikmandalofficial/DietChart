package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.adapter.CustomAdapter;
import com.app.dietchartfinal.adapter.FoodAdapter;
import com.app.dietchartfinal.model.FoodInformationModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodInformationActivity extends AppCompatActivity {

    RecyclerView rv1,rv2;
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Fruit", "Meat", "FastFood", "Vegetable", "Egg", "Tomato", "Vegetable","Fruit", "Meat", "FastFood", "Vegetable", "Egg", "Tomato", "Vegetable"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7,R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7));
    LinearLayoutManager linearLayoutManager;
    List<Integer> foodlist;
    FoodAdapter foodAdapter;
    ImageView home;
    ArrayList<FoodInformationModel> foodInformationModelArrayList = new ArrayList<>();
    ArrayList<FoodInformationModel.Suggestion> suggestionList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_information);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rv1 = findViewById(R.id.rv1);
        home= findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(FoodInformationActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv1.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(FoodInformationActivity.this, foodInformationModelArrayList);
        rv1.setAdapter(customAdapter);


        initData();
        initRecyclerView();



    }

    private void initData() {
        foodlist = new ArrayList<Integer>();
        foodlist.add(R.drawable.person6);
        foodlist.add(R.drawable.p2);
        foodlist.add(R.drawable.person1);
        foodlist.add(R.drawable.person2);
        foodlist.add(R.drawable.person3);
        foodlist.add(R.drawable.person4);
        foodlist.add(R.drawable.person5);
        foodlist.add(R.drawable.person6);
        foodlist.add(R.drawable.person7);
        foodlist.add(R.drawable.person1);
        foodlist.add(R.drawable.person2);

    }

    private void initRecyclerView() {
        rv2=findViewById(R.id.rv2);
        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rv2.setLayoutManager(linearLayoutManager);
        foodAdapter=new FoodAdapter(foodlist);
        rv2.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
    }


    /*public int getImgFood() {

        return 0;
    }

    public int getTvFood() {
        return 0;
    }*/
}