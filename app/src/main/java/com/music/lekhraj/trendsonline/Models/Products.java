package com.music.lekhraj.trendsonline.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable
{

    @SerializedName("products")
    @Expose
    private List<Products_detilas> products = null;
    private final static long serialVersionUID = -3943058481498962571L;

    public List<Products_detilas> getProducts() {
        return products;
    }

    public void setProducts(List<Products_detilas> products) {
        this.products = products;
    }

}
