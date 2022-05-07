package com.example.project2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MealsService {
    @POST("food")
    Call<MealsResponse> meals(@Body MealsRequest mealsRequest) ;
}
