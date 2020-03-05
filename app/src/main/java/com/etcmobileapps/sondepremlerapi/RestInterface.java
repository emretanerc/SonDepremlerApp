package com.etcmobileapps.sondepremlerapi;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {
    @GET("api")
    Call<List<Repo>> depremListele();
}