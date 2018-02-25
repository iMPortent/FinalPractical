package com.example.c4q.finalpractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final private static String sharedPrefKey = "finals_practical_preferences";
    public static SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(sharedPrefKey, MODE_PRIVATE);

        Intent toLogin = new Intent(this, LoginActivity.class);
        startActivity(toLogin);


    }


    public static String getSharedPrefKey(){
        return sharedPrefKey;
    }
}
