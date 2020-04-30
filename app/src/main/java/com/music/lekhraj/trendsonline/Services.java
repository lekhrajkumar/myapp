package com.music.lekhraj.trendsonline;

import com.music.lekhraj.trendsonline.Models.Products;
import com.music.lekhraj.trendsonline.Models.Products_detilas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
   /* @GET("product&api_token")
    Call<Products> g;*/

    @GET("product&api_token=123")
    Call<List<Products_detilas>> getProducts();


}
