package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.utility.MyDbAdapter;

public class ProfileActivity extends AppCompatActivity {
    EditText etUserName;
    EditText etPassword;
    EditText etEmaill;
    MyDbAdapter helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        helper = new MyDbAdapter(this);

        etUserName= findViewById(R.id.etUserName);
        etPassword= findViewById(R.id.etPassword);
        etEmaill= findViewById(R.id.etEmaill);
    }

    public void Update(View view) {
        SharedPreferences sh = getSharedPreferences("DietCharSharedPref", MODE_PRIVATE);
        String oldpass=sh.getString("pass","");
        String oldusername=sh.getString("username","");

        if(  helper.updateName(oldusername,etUserName.getText().toString(),oldpass,etPassword.getText().toString()))
            Toast.makeText(this,"Successfully updated",Toast.LENGTH_LONG).show();
        else Toast.makeText(this,"Unsuccessful",Toast.LENGTH_LONG).show();

    }
}