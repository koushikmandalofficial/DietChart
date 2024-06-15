package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.utility.Message;
import com.app.dietchartfinal.utility.MyDbAdapter;

import java.util.ArrayList;

public class UserdetailsActivity extends AppCompatActivity {
    ImageView back;
    EditText etName, etAge, etHeight, etAnswer, delete;
    MyDbAdapter helper;
    ArrayList<String> data = new ArrayList<>();
    CardView cvSignup;
    Spinner spGender,spDisease,spQuestion;
    String username,pass,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        setGendarSpinner();
        setDisease();
        setQuestion();
        clicklistner();


    }

    private void setQuestion() {
        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Favourite Food?");
        spinnerArray.add("Favourite pet?");
        spinnerArray.add("First School?");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spQuestion.setAdapter(spinnerArrayAdapter);

    }

    private void setDisease() {
        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("None");
        spinnerArray.add("Sugar");
        spinnerArray.add("High pressure");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spDisease.setAdapter(spinnerArrayAdapter);

    }

    private void setGendarSpinner() {

        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Male");
        spinnerArray.add("Female");
        spinnerArray.add("Other");
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spGender.setAdapter(spinnerArrayAdapter);

    }

    private void clicklistner() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

        cvSignup.setOnClickListener(V -> {
            adduser();
            getuserData() ;
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void getuserData() {
        String data1 = helper.getData();
        data.clear();
        data.add(data1);
        Log.e("userlist",data1);
        //  Message.message(this,data1);
    }

    private void adduser() {
        String name = etName.getText().toString();
        String gender =spGender.getSelectedItem().toString();
        String age = etAge.getText().toString();
        String hight = etHeight.getText().toString();
        String diseasee = spDisease.getSelectedItem().toString();
        String question = spQuestion.getSelectedItem().toString();
        String ans = etAnswer.getText().toString();
        String usernam = username;
        String emai = email;
        String pas = pass;
        if (name.isEmpty() || age.isEmpty()|| hight.isEmpty()|| ans.isEmpty()|| usernam.isEmpty()|| emai.isEmpty()|| pas.isEmpty()) {
            Message.message(getApplicationContext(), "Enter full details");
        } else {
            long id = helper.insertData(name, gender,age,hight,diseasee,question,ans,usernam,emai,pas);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                /*Name.setText("");
                Pass.setText("");*/
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
              /*  Name.setText("");
                Pass.setText("");*/
            }
        }
    }

    private void initView() {
        helper = new MyDbAdapter(this);
        back = findViewById(R.id.back);
        cvSignup = findViewById(R.id.cvSignup);
        etName = findViewById(R.id.etName);
        spGender = findViewById(R.id.spGender);
        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        spDisease = findViewById(R.id.spDisease);
        spQuestion = findViewById(R.id.spQuestion);
        etAnswer = findViewById(R.id.etAnswer);

        username=getIntent().getStringExtra("username");
        email=getIntent().getStringExtra("email");
        pass=getIntent().getStringExtra("password");
    }
}