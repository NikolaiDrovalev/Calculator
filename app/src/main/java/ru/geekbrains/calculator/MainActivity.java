package ru.geekbrains.calculator;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView screen;
    final static String screenKey = "key";
    private static final String PREF_NAME = "key_pref";
    private static final String PREF_THEME_KEY = "key_pref_theme";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme());
        setContentView(R.layout.activity_main);
        initView();
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

        findViewById(R.id.radioButtonDefault).setOnClickListener(this);
        findViewById(R.id.radioButtonRed).setOnClickListener(this);
        findViewById(R.id.radioButtonGreen).setOnClickListener(this);
        findViewById(R.id.radioButtonBlue).setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(screenKey, screen.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        screen.setText(savedInstanceState.getString(screenKey));
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

        switch (view.getId()) {
            case (R.id.radioButtonDefault):
                setAppTheme(R.style.Theme_Calculator);
                break;
            case (R.id.radioButtonRed):
                setAppTheme(R.style.Theme_Red);
                break;
            case (R.id.radioButtonGreen):
                setAppTheme(R.style.Theme_Green);
                break;
            case (R.id.radioButtonBlue):
                setAppTheme(R.style.Theme_Blue);
                break;
        }
        recreate();
    }

    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(PREF_THEME_KEY, codeStyle);
        editor.apply();
    }

    protected int getAppTheme() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return sharedPref.getInt(PREF_THEME_KEY, R.style.Theme_Calculator);
    }
}