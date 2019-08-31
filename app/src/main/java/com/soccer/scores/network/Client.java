package com.soccer.scores.network;
import com.soccer.scores.network.datamodel.Matches;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "http://api.football-data.org";

    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient
            .Builder()
            .addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("X-Auth-Token", "764ce02b96334df29320740e922dd552").build();
                return chain.proceed(request);
            });

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.client(httpClientBuilder.build()).build();
    private static IClient iClient = retrofit.create(IClient.class);

    public static void getMatchesList(Callback<Matches> callback,String dateFrom,String dateTo) {
        Call<Matches> getMatchesList = iClient.getMatchesList(dateFrom,dateTo);
        getMatchesList.enqueue(callback);
    }
}
