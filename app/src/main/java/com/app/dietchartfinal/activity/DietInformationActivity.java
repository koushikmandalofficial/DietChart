package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.adapter.DietAdaptor;
import com.app.dietchartfinal.adapter.DietpageAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class DietInformationActivity extends AppCompatActivity {
    RecyclerView recyclerView, recyclerView2;
    ImageView home, bar,fooddetails;
    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Breakefast", "Lunch", "Dinner", "Tiffin"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.breakfast, R.drawable.lunch, R.drawable.dinner, R.drawable.tiffin1));

    ArrayList<String> foodNames = new ArrayList<>(Arrays.asList("Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable", "Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable"));
    ArrayList<Integer> foodImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7, R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_information);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView2 = findViewById(R.id.recyclerView2);
        home = findViewById(R.id.home);
        bar = findViewById(R.id.bar);
        fooddetails = findViewById(R.id.fooddetails);

        fooddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DietInformationActivity.this, FoodDetailsActivity.class);
                startActivity(intent2);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DietInformationActivity.this, HomeActivity.class);
                startActivity(intent1);
            }
        });
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        DietAdaptor customAdapter = new DietAdaptor(DietInformationActivity.this, personNames, personImages);
        recyclerView.setAdapter(customAdapter);


        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        DietpageAdapter customAdapter2 = new DietpageAdapter(DietInformationActivity.this, foodNames, foodImages);
        recyclerView2.setAdapter(customAdapter2);
    }


    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.fragment_bottom_sheet);
        RelativeLayout aboutus = dialog.findViewById(R.id.aboutus);
        RelativeLayout contactus = dialog.findViewById(R.id.contactus);
        RelativeLayout appversion = dialog.findViewById(R.id.appversion);
        RelativeLayout timer = dialog.findViewById(R.id.timer);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DietInformationActivity.this, AboutUsActivity.class);
                startActivity(intent1);
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DietInformationActivity.this, TimerActivity.class);
                startActivity(intent2);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(DietInformationActivity.this, ContactUsActivity.class);
                startActivity(intent3);
            }
        });
        appversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DietInformationActivity.this, "You are currently on 1.0.0 version", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}