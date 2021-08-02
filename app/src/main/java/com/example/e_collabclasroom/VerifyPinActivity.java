package com.example.e_collabclasroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class VerifyPinActivity extends AppCompatActivity {
    Pinview pinview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_pin);
        pinview = findViewById(R.id.pinview);
        SharedPreferences preferences = getSharedPreferences("role", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                if (pinview.getValue().equals("751399")){
                    finish();
                    Intent intent = new Intent(VerifyPinActivity.this, MainMenu.class);
                    editor.putString("role","admin");
                    editor.commit();
                    startActivity(intent);
                }
                else {
                    pinview.clearValue();
                }
            }
        });
    }
}