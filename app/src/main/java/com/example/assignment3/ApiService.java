package com.example.assignment3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    public static String BASE_URL = "https://corona.lmao.ninja/v2/";

    @GET("all")
    Call<Covid> getCovid();
}
