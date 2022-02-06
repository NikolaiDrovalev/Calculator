package ru.geekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

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
        screen = findViewById(R.id.screen);

        ((RadioButton) findViewById(R.id.radioButtonDefault)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonRed)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonGreen)).setOnClickListener(this);
        ((RadioButton) findViewById(R.id.radioButtonBlue)).setOnClickListener(this);
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

    public void numbers(View view) {
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
                String newNumber = number.substring(0, number.length() - 1);
                number = newNumber;
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
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
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