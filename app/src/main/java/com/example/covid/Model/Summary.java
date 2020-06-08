package com.example.covid.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Summary {
    @SerializedName("Date")
    String date;
    @SerializedName("Global")
    Global global;
    @SerializedName("Countries")
    public List<Country> countries;
}

class Global {

}

