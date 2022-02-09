package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    static final String PREF_NAME = "key_pref";
    static final String PREF_THEME_KEY = "key_pref_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getAppTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    public void initView(){
        findViewById(R.id.radioButtonDefault).setOnClickListener(this);
        findViewById(R.id.radioButtonRed).setOnClickListener(this);
        findViewById(R.id.radioButtonGreen).setOnClickListener(this);
        findViewById(R.id.radioButtonBlue).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.radioButtonDefault):
                setAppTheme(R.style.Theme_Calculator);
                Intent intent_default = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent_default);
                break;
            case (R.id.radioButtonRed):
                setAppTheme(R.style.Theme_Red);
                Intent intent_red = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent_red);
                break;
            case (R.id.radioButtonGreen):
                setAppTheme(R.style.Theme_Green);
                Intent intent_green = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent_green);
                break;
            case (R.id.radioButtonBlue):
                setAppTheme(R.style.Theme_Blue);
                Intent intent_blue = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent_blue);
                break;
        }
        recreate();
        finish();
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