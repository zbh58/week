package com.example.week.api;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ResponseBody> get(@Url String url);
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url);
    @POST
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url, @FieldMap HashMap<String,String> map);
}
