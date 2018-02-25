package com.example.c4q.finalpractical;

import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;

/**
 * Created by c4q on 2/25/18.
 */

public class BreedsActivity extends AppCompatActivity {

    TextView greeting;
    ImageView terrier, poodle, retriever, spaniel;
    RetrofitFactory.OneDogNetworkListener listener, listener2, listener3, listener4;
    String[] breeds = {"terrier", "spaniel","retriever","poodle"};
    HashMap<String,String> urlList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_activity);
        urlList = new HashMap<>();

        greeting = findViewById(R.id.top_greeting);
        terrier = findViewById(R.id.image_terrier);
        spaniel = findViewById(R.id.image_spaniel);
        retriever = findViewById(R.id.image_retriever);
        poodle = findViewById(R.id.image_poodle);
        ImageView[] imagesV = {terrier, spaniel, retriever, poodle};

        Resources res = getResources();
        String text = String.format(res.getString(R.string.greeting), getIntent().getStringExtra("login"));
        greeting.setText(text);

        getUrls("terrier");
        getUrls("spaniel");
        getUrls("retriever");
        getUrls("poodle");

        for(int i = 0; i < breeds.length;i++){
            setImage(breeds[i],imagesV[i]);
        }

    }



    public void getUrls(final String breed){
        listener = new RetrofitFactory.OneDogNetworkListener() {

            @Override
            public void singleDogCallback(DogModel response) {
                String url = response.getMessage();
                urlList.put(breed, url);
            }
        };

        RetrofitFactory.getInstance().setOneDogNetworkListener(listener);
        RetrofitFactory.getInstance().getDog(breed);
    }

    public void setImage(String breed, ImageView view){
        Glide.with(getApplicationContext())
                .load(urlList.get(breed))
                .into(view);
    }

    public void getBreed(View view){
        int id = view.getId();
        Intent takeBreed = new Intent(this, DogsActivty.class);
        switch(id){
            case R.id.card_terrier:
                takeBreed.putExtra("breed", "terrier");
                break;

            case R.id.card_retriever:
                takeBreed.putExtra("breed", "retriever");
                break;

            case R.id.card_spaniel:
                takeBreed.putExtra("breed", "spaniel");
                break;

            case R.id.card_poodle:
                takeBreed.putExtra("breed", "poodle");
                break;

            default:
                Log.d("TAG", "getBreed: failed");
                break;
        }
        startActivity(takeBreed);
    }



}
