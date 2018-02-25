package com.example.c4q.finalpractical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

/**
 * Created by c4q on 2/25/18.
 */

public class BreedsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_activity);
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
