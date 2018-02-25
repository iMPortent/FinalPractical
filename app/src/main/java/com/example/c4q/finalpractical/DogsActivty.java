package com.example.c4q.finalpractical;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by c4q on 2/25/18.
 */

public class DogsActivty extends AppCompatActivity {

    RetrofitFactory.DogNetworkListener dogNetworkListener;

    String breed;
    RecyclerView recyclerDogs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dogs_activity);


        breed = getIntent().getStringExtra("breed");
//        dogUrl = "https://dog.ceo/api/breed/" + breed + "/images/random";
//        dogsUrl = "https://dog.ceo/api/breed/" + breed + "/images";
        getDogList();
        recyclerDogs = findViewById(R.id.recycler_dogs);
        recyclerDogs.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));


    }

    public void getDogList() {
        dogNetworkListener = new RetrofitFactory.DogNetworkListener() {
            @Override
            public void doggieCallback(DogsModel response) {

                ArrayList<String> urlList = response.getMessage();
                DogAdapter adapter = new DogAdapter(urlList);
                recyclerDogs.setAdapter(adapter);
            }
        };
        RetrofitFactory.getInstance().setDogNetworkListener(dogNetworkListener);
        RetrofitFactory.getInstance().getListDogs(breed);
    }

}
