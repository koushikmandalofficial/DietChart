package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.app.dietchartfinal.R;
import com.app.dietchartfinal.utility.Message;
import com.app.dietchartfinal.utility.MyDbAdapter;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    TextView sigup;
    TextView forgotpass;
    CardView sigin;
    MyDbAdapter helper;
    EditText etUsername;
    EditText etpass;
    ArrayList<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        helper = new MyDbAdapter(this);
        etUsername=findViewById(R.id.etUsername);
        etpass=findViewById(R.id.etpass);
        sigup=findViewById(R.id.sigup);
        forgotpass=findViewById(R.id.forgotpass);
        sigin=findViewById(R.id.sigin);
        getuserData() ;
        sigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent1);
            }
        });
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(helper.getLoginState(etUsername.getText().toString(),etpass.getText().toString())) {
                    SharedPreferences sh = getSharedPreferences("DietCharSharedPref", MODE_PRIVATE);

                    SharedPreferences.Editor myEdit = sh.edit();
                    // write all the data entered by the user in SharedPreference and apply
                    myEdit.putBoolean("loginstate", true);
                    myEdit.putString("username", etUsername.getText().toString());
                    myEdit.putString("pass", etpass.getText().toString());
                    myEdit.putString("Age",helper.getAge(etUsername.getText().toString(),etpass.getText().toString()));
                    myEdit.apply();

                    Intent intent2 = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent2);
                    finish();
                }else {
                    Message.message(getApplicationContext(), "Invalid password");
                }
            }
        });

    }

    private void getuserData() {
        String data1 = helper.getData();
        data.clear();
        data.add(data1);
        Log.e("userlist",data1);
        //  Message.message(this,data1);
    }
}