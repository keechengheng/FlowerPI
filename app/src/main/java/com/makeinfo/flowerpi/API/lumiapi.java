package com.makeinfo.flowerpi.API;


import com.makeinfo.flowerpi.model.lumimodel;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by keechengheng on 19/7/15.
 */
public interface lumiapi {

    @GET("/logins/{login}")
    public void getFeed(@Path("login") String login, Callback<lumimodel> response);

    @POST("/logins/")
    public void sendFeed(@Body lumimodel lumimodel, Callback<lumimodel> response);

}
