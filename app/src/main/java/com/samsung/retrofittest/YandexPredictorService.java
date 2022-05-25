package com.samsung.retrofittest;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YandexPredictorService {

    private static final String YANDEX_URL = "https://predictor.yandex.net/api/v1/predict.json/";

    public static final String API_KEY = "pdct.1.1.20220518T172109Z.e748ac891d91b060.05352147d8955a46b077d7eb62696ed2db38447c";

    private static YandexPredictorApi API;

    static {
        API = getYandexPredictorApi();
    }

    public static YandexPredictorApi getYandexPredictorApi() {
        return new Retrofit.Builder()
                .baseUrl(YANDEX_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YandexPredictorApi.class);
    }


    public static Predict getPredict(String query, Integer limit) {
        Call<Predict> call = API.getPredict(API_KEY, "en", query, limit);
        try {
            Response<Predict> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Retrofit read exception");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
