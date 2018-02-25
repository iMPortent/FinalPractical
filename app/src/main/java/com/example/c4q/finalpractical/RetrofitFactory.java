package com.example.c4q.finalpractical;

import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by C4Q on 1/23/2018.
 */

public class RetrofitFactory {

    public static RetrofitFactory retrofitFactory;
    private  Retrofit retrofit;
    private DogNetworkListener dogNetworkListener;
    private OneDogNetworkListener oneDogNetworkListener;

    public static RetrofitFactory getInstance(){
        if(retrofitFactory == null ) {
            retrofitFactory = new RetrofitFactory();
        }
        return retrofitFactory;
    }

    public void setDogNetworkListener(DogNetworkListener dogyNetworkListener){
        this.dogNetworkListener = dogyNetworkListener;
    }

    public void setOneDogNetworkListener(OneDogNetworkListener oneDogNetworkListener){
        this.oneDogNetworkListener = oneDogNetworkListener;
    }





    private Retrofit buildRetro() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://dog.ceo/api/breed/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



    public void getListDogs(String breed){
        DogService dogService = buildRetro().create(DogService.class);
        Call<DogsModel> getServiceResponse = dogService.getDogs(breed);
        getServiceResponse.enqueue(new Callback<DogsModel>() {

            @Override
            public void onResponse(Call<DogsModel> call, Response<DogsModel> response) {
                if(response.isSuccessful()){
                    if(dogNetworkListener!=null){
                        dogNetworkListener.doggieCallback(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<DogsModel> call, Throwable t) {
                Log.e("TAG","Failed");
            }
        });
    }

    public void getDog(String breed){
        DogService dogService = buildRetro().create(DogService.class);
        Call<DogModel> getServiceResponse = dogService.getDog(breed);
        getServiceResponse.enqueue(new Callback<DogModel>() {

            @Override
            public void onResponse(Call<DogModel> call, Response<DogModel> response) {
                if(response.isSuccessful()){
                    if(oneDogNetworkListener!=null){
                        oneDogNetworkListener.singleDogCallback(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<DogModel> call, Throwable t) {
                Log.e("TAG","Failed");
            }
        });
    }



    public interface DogNetworkListener {
        void doggieCallback(DogsModel response);
    }

    public interface OneDogNetworkListener {
        void singleDogCallback(DogModel response);

    }
}
