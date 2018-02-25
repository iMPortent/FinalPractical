package com.example.c4q.finalpractical;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/25/18.
 */

public interface DogService {
    @GET("{breed}/images")
    Call<DogsModel>getDogs(@Path("breed") String breed);
}
