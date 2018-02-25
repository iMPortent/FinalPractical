package com.example.c4q.finalpractical;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends MyActivities {

    final private static String sharedPrefKey = "finals_practical_preferences";
    public static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(sharedPrefKey, MODE_PRIVATE);

        if(preferences.contains("username")){
            Intent skipLogin = new Intent(this, BreedsActivity.class);
            skipLogin.putExtra("login", preferences.getString("username", "username"));
            startActivity(skipLogin);
        } else {

            Intent toLogin = new Intent(this, LoginActivity.class);
            startActivity(toLogin);
        }

    }


}
