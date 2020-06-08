package com.example.covid.Model;


public class Case {




    private int Global;
    private int Country;
    private int NewConfirmed;
    private int totalConfirmed;
    private int NewDeaths;
    private int totalDeaths;
    private int NewRecovered;
    private int TotalRecovered;

    public int getGlobal() {
        return Global;
    }
    public int getCountry() {
        return Country;
    }
    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

}
