package com.soccer.scores.network;

import com.soccer.scores.network.datamodel.Matches;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IClient {

    @GET
    Call<Matches> getMachesList(@Url String url);

}
