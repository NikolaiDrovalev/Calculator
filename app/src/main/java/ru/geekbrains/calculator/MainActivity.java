package ru.geekbrains.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView screen;
    static final String SCREEN_KEY_ONE = "keyOne";
    static final String SCREEN_KEY_TWO = "keyTwo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getAppTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        screen.setText(getScreenSave());
    }

    protected int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(SecondActivity.PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(SecondActivity.PREF_THEME_KEY, R.style.Theme_Calculator);
    }

    public void initView() {
        screen = findViewById(R.id.screen);

        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.point).setOnClickListener(this);
        findViewById(R.id.equals).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.percent).setOnClickListener(this);
        findViewById(R.id.delete_one_sign).setOnClickListener(this);
        findViewById(R.id.delete_everything).setOnClickListener(this);

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String number = screen.getText().toString();
        switch (view.getId()) {
            case (R.id.zero):
                number += "0";
                break;
            case (R.id.one):
                number += "1";
                break;
            case (R.id.two):
                number += "2";
                break;
            case (R.id.three):
                number += "3";
                break;
            case (R.id.four):
                number += "4";
                break;
            case (R.id.five):
                number += "5";
                break;
            case (R.id.six):
                number += "6";
                break;
            case (R.id.seven):
                number += "7";
                break;
            case (R.id.eight):
                number += "8";
                break;
            case (R.id.nine):
                number += "9";
                break;
            case (R.id.point):
                number += ".";
                break;
            case (R.id.delete_everything):
                number = "";
                break;
            case (R.id.delete_one_sign):
                number = number.substring(0, number.length() - 1);
                break;
            case (R.id.percent):
                number += "%";
                break;
            case (R.id.multiply):
                number += "*";
                break;
            case (R.id.minus):
                number += "-";
                break;
            case (R.id.plus):
                number += "+";
                break;
            case (R.id.divide):
                number += "÷";
                break;
            case (R.id.equals):
                number += "=";
                break;
        }
        screen.setText(number);
        setScreenSave(screen.getText().toString());
    }

    protected void setScreenSave(String screenSave) {
        SharedPreferences sharedPref = getSharedPreferences(SCREEN_KEY_ONE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SCREEN_KEY_TWO, screenSave);
        editor.apply();
    }

    protected String getScreenSave() {
        SharedPreferences sharedPref = getSharedPreferences(SCREEN_KEY_ONE, MODE_PRIVATE);
        return sharedPref.getString(SCREEN_KEY_TWO, screen.getText().toString());
    }
}