package ru.geekbrains.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String newScreen;
    final static String screenKey = "key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState){
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
}