package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.adapter.CustomAdapter;
import com.app.dietchartfinal.adapter.SliderAdapter;
import com.app.dietchartfinal.model.FoodInformationModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout indicator;
    ImageView bar, notification;
    RelativeLayout aboutus, contactus;
    RelativeLayout cardview2, timer, dietinformtion;

    List<Integer> color;
    List<String> colorName;

    ArrayList<String> personNames = new ArrayList<>(Arrays.asList("Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable", "Furit", "Meat", "FastFood", "Vegitable", "Egg", "Tomato", "Vegitable"));
    ArrayList<Integer> personImages = new ArrayList<>(Arrays.asList(R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7, R.drawable.person1, R.drawable.person2, R.drawable.person3, R.drawable.person4, R.drawable.person5, R.drawable.person6, R.drawable.person7));
    ArrayList<FoodInformationModel> foodInformationModelArrayList = new ArrayList<>();
    ArrayList<FoodInformationModel> suggestionList;
    RecyclerView filterrv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        filterrv= findViewById(R.id.recyclerView);
        bar = findViewById(R.id.bar);
        aboutus = findViewById(R.id.aboutus);
        contactus = findViewById(R.id.contactus);
        cardview2 = findViewById(R.id.cardview2);
        dietinformtion = findViewById(R.id.dietinformtion);
        timer = findViewById(R.id.timer);
        notification = findViewById(R.id.notification);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (TabLayout) findViewById(R.id.indicator);
        color = new ArrayList<>();
        color.add(R.drawable.banner1);
        color.add(R.drawable.banner2);
        color.add(R.drawable.banner3);


        colorName = new ArrayList<>();
        colorName.add("RED");
        colorName.add("GREEN");
        colorName.add("BLUE");

        viewPager.setAdapter(new SliderAdapter(this, color, colorName));
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 3000, 6000);



       //todo:real data insert regarding food filter
       datainsert();

    }

    private void datainsert() {
        suggestionList = new ArrayList<>();
        suggestionList.add(new FoodInformationModel(2, R.drawable.banana, "Banana", "1.1 g",  "0.3 g","89", "22.8 g", this.getString(R.string.bananadetails), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.grapes, "Grapes", "0.72 g",  "0.16 g", "72","18.1 g", this.getString(R.string.grapes), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.guava, "Guava", "2.55 g",  "0.95 g", "75","14.32 g", this.getString(R.string.guavas), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.litchi, "Litchi", "0.8 g" ,"0.4 g", "66","16.5 g", this.getString(R.string.litchi), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.jackfruit, "Jackfruit", "23 g" , "1 g","143", "35 g", this.getString(R.string.jackfruit), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.pineapple, "Pineapple", "1 g",  "1.7 g", "83","21.6 g", this.getString(R.string.pineapple), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.orange, "Orange", "0.7 g", "0.3 g","47",  "12 g", this.getString(R.string.orange), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.strawberry, "Strawberry", "1.1 1g",  "1 g", "53","12.7 g", this.getString(R.string.strawberry), suggestionList));

        suggestionList.add(new FoodInformationModel(2, R.drawable.potato, "Potato", "0.9 g", "0 g", "265", "61 g", this.getString(R.string.Potato), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.person6, "Tomato", "0.9 g", "0.2 g", "18", "3.9 g", this.getString(R.string.Tomato), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.onion, "Onion", "0.1 g", "0.1 g", "40", "9.3 g", this.getString(R.string.onion), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.cauliflower, "Cauliflower", "2 g", "0 g", "25", "5 g", this.getString(R.string.Cauliflower), suggestionList));

        suggestionList.add(new FoodInformationModel(2, R.drawable.person2, "Chicken", "27 g", "3.6 g", "239", "0 g", this.getString(R.string.chickenDetails), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.fish, "Fish", "22 g", "12 g", "206", "0 g", this.getString(R.string.fishDetails), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.milk, "Milk", "3.4 g", "1 g", "42", "5 g", this.getString(R.string.milkDetails), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.egg, "Egg", "6 g", "5 g", "78", "0.6 g", this.getString(R.string.eggDetails), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.bread, "Bread", "9 g", "3.2 g", "100", "40 g", this.getString(R.string.breadDeteils), suggestionList));
        suggestionList.add(new FoodInformationModel(2, R.drawable.mutton, "Mutton", "25 g", "21 g", "294", "0g ", this.getString(R.string.muttonDeteils), suggestionList));




        foodInformationModelArrayList = new ArrayList<>();
        foodInformationModelArrayList.add(new FoodInformationModel(1, R.drawable.apple, "Apple", "0.3 g",  "0.2 g", "52","13.8 g", this.getString(R.string.appeldetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.banana, "Banana", "1.1 g",  "0.3 g","89", "22.8 g", this.getString(R.string.bananadetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.grapes, "Grapes", "0.72 g",  "0.16 g", "72","18.1 g", this.getString(R.string.grapes), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.guava, "Guava", "2.55 g",  "0.95 g", "75","14.32 g", this.getString(R.string.guavas), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.litchi, "Litchi", "0.8 g" ,"0.4 g", "66","16.5 g", this.getString(R.string.litchi), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.jackfruit, "Jackfruit", "23 g" , "1 g","143", "35 g", this.getString(R.string.jackfruit), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.pineapple, "Pineapple", "1 g",  "1.7 g", "83","21.6 g", this.getString(R.string.pineapple), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.orange, "Orange", "0.7 g", "0.3 g","47",  "12 g", this.getString(R.string.orange), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.strawberry, "Strawberry", "1.1 1g",  "1 g", "53","12.7 g", this.getString(R.string.strawberry), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.mango, "Mango", "1.35 g",  "0.63 g", "99","24.8 g", this.getString(R.string.mango), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.blackberry, "Blackberry", "1.4 g",  "0.5 g","43", "10.2 g", this.getString(R.string.blackberry), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.watermelon, "Watermelon", "0.6 g",  "0.2 g", "30 ","7.6 g", this.getString(R.string.watermelon), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.coconut, "Coconut", "3 g",  "1 g","70", "15 g", this.getString(R.string.coconut), suggestionList));

        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.potato, "Potato", "0.9 g", "0 g", "265", "61 g", this.getString(R.string.Potato), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.person6, "Tomato", "0.9 g", "0.2 g", "18", "3.9 g", this.getString(R.string.Tomato), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.onion, "Onion", "0.1 g", "0.1 g", "40", "9.3 g", this.getString(R.string.onion), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.cauliflower, "Cauliflower", "2 g", "0 g", "25", "5 g", this.getString(R.string.Cauliflower), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.carrot, "Carrot", "0.9 g", "0.2 g", "41", "9.6 g", this.getString(R.string.Carrot), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.ginger, "Ginger", "0.9 g", "0.4 g", "32", "6.9 g", this.getString(R.string.Ginger), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.garlic, "Garlic", "0.2 g", "0 g", "40", "1 g", this.getString(R.string.Garlic), suggestionList));

        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.person2, "Chicken", "27 g", "3.6 g", "239", "0 g", this.getString(R.string.chickenDetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.fish, "Fish", "22 g", "12 g", "206", "0 g", this.getString(R.string.fishDetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.milk, "Milk", "3.4 g", "1 g", "42", "5 g", this.getString(R.string.milkDetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.egg, "Egg", "6 g", "5 g", "78", "0.6 g", this.getString(R.string.eggDetails), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.bread, "Bread", "9 g", "3.2 g", "100", "40 g", this.getString(R.string.breadDeteils), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.mutton, "Mutton", "25 g", "21 g", "294", "0g ", this.getString(R.string.muttonDeteils), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.rice, "Rice", "2.7 g", "3.2 g", "130", "25 g", this.getString(R.string.riceDeteils), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.chocklet, "Dark Chocolate", "2 g", "12 g", "170", "13 g", this.getString(R.string.darkChocolateDeteils), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.pizza, "Pizza", "11 g", "10 g", "240", "30 g", this.getString(R.string.pizzaDeteils), suggestionList));
        foodInformationModelArrayList.add(new FoodInformationModel(2, R.drawable.person3, "Burger", "17 g", "12 g", "275", "22 g", this.getString(R.string.burgerDeteils), suggestionList));

        setAdapterForFilter();
    }

    private void setAdapterForFilter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        filterrv.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(HomeActivity.this, foodInformationModelArrayList);
        filterrv.setAdapter(customAdapter);
        clicklistner();
    }

    private void clicklistner() {
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, FoodInformationActivity.class);
                startActivity(intent1);
            }
        });
        dietinformtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this, DietInformationActivity.class);
                startActivity(intent2);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialog() {
        Rect displayRectangle = new Rect();
        Window window = this.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.fragment_bottom_sheet, null);
        RelativeLayout aboutus = layout.findViewById(R.id.aboutus);
        RelativeLayout contactus = layout.findViewById(R.id.contactus);
        RelativeLayout appversion = layout.findViewById(R.id.appversion);
        RelativeLayout timer = layout.findViewById(R.id.timer);
        RelativeLayout profile = layout.findViewById(R.id.profile);
        RelativeLayout logout = layout.findViewById(R.id.logout);
        logout.setOnClickListener(V->{
            SharedPreferences sh = getSharedPreferences("DietCharSharedPref", MODE_PRIVATE);

            SharedPreferences.Editor myEdit = sh.edit();
            // write all the data entered by the user in SharedPreference and apply
            myEdit.putBoolean("loginstate",false);
            myEdit.apply();
            Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent1);
            finish();
        });
        profile.setOnClickListener(V->{
            Intent intent1 = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent1);
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, AboutUsActivity.class);
                startActivity(intent1);
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this, TimerActivity.class);
                startActivity(intent2);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomeActivity.this, ContactUsActivity.class);
                startActivity(intent3);
            }
        });
        appversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "You are currently on 1.0.0 version", Toast.LENGTH_SHORT).show();
            }
        });
        BottomSheetDialog dialog = new BottomSheetDialog(this, R.style.BottomSheetDialog);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(layout);
        dialog.show();

    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < color.size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}