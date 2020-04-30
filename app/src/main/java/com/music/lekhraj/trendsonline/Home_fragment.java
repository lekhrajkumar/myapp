package com.music.lekhraj.trendsonline;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.music.lekhraj.trendsonline.Models.Products;
import com.music.lekhraj.trendsonline.Models.Products_detilas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_fragment extends Fragment {
    private Home_Adapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;


    //List<Products_detilas> products_detilas;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView=view.findViewById(R.id.view_gr);
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        Services service = ApiClient.getClient().create(Services.class);
        Call<List<Products_detilas>> call = service.getProducts();
        call.enqueue(new Callback<List<Products_detilas>>() {
            @Override
            public void onResponse(Call<List<Products_detilas>> call, Response<List<Products_detilas>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Products_detilas>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Products_detilas> product_list) {

        adapter = new Home_Adapter(getActivity(), product_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    }





