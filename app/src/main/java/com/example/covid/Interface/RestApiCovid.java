package com.example.covid.Interface;

import com.example.covid.Model.Case;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiCovid {
    @GET("summary")
    Call<List<Case>> getCases();
}
