package com.example.c4q.finalpractical;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by c4q on 2/25/18.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {

    ArrayList<String> urls;

    public DogAdapter(ArrayList<String>urls){
        this.urls = urls;
    }

    @Override
    public DogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doggies, parent, false);
        return new DogHolder(view);
    }

    @Override
    public void onBindViewHolder(DogHolder holder, int position) {
        holder.bind(urls.get(position));
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class DogHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageView dogImage;

        public DogHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            dogImage = itemView.findViewById(R.id.item_dog_image);
        }

        public void bind(String url){
            Glide.with(context)
                    .load(url)
                    .into(dogImage);
        }
    }
}
