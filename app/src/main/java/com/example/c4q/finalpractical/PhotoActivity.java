package com.example.c4q.finalpractical;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by c4q on 2/25/18.
 */

public class PhotoActivity extends AppCompatActivity {

    ImageView thePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);

        thePhoto = findViewById(R.id.full_image_dog);

        Glide.with(this)
                .load(getIntent().getStringExtra("url"))
                .into(thePhoto);


    }
}
