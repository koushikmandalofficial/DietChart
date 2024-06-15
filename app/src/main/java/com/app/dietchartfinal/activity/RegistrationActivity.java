package com.app.dietchartfinal.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.dietchartfinal.R;

public class RegistrationActivity extends AppCompatActivity {
    TextView sigin;
    ImageView back;
    CardView next;
    EditText etUserName,etPassword,etEmaill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initView();
        clickListner();


    }

    private void clickListner() {
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent1);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(RegistrationActivity.this, UserdetailsActivity.class);
                intent2.putExtra("username",etUserName.getText().toString());
                intent2.putExtra("password",etPassword.getText().toString());
                intent2.putExtra("email",etEmaill.getText().toString());
                startActivity(intent2);

            }
        });
    }

    private void initView() {
        sigin = findViewById(R.id.sigin);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        etEmaill = findViewById(R.id.etEmaill);
    }
}