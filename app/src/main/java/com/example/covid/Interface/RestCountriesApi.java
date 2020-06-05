package com.example.covid.Interface;

import com.example.covid.Model.CountriesEurope;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestCountriesApi {
    @GET("rest/v2/region/europe")
    Call<List<CountriesEurope>> getCountries();
}
