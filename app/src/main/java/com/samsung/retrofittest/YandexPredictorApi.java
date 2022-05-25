package com.samsung.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YandexPredictorApi {

    @GET("complete")
    Call<Predict> getPredict(
            @Query("key") String key,
            @Query("lang") String lang,
            @Query("q") String query,
            @Query("limit") Integer limit
    );

}
