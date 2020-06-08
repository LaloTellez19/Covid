package com.example.covid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.covid.Interface.RestCountriesApi;
import com.example.covid.Model.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

enum Continente {
    Asia,
    America,
    Europa,
    Africa,
    Oceania
}

public class ContinentesFragment extends Fragment {
    static final String TAG = "ContinentesFragment";
    private TextView textopa;
    ImageView europaim, asiaim, americaim,africaim, oceaniaim;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continentes,container,false);
        europaim = (ImageView) view.findViewById(R.id.europa);
        asiaim = (ImageView) view.findViewById(R.id.asia);
        americaim = (ImageView) view.findViewById(R.id.america);
        africaim = (ImageView) view.findViewById(R.id.africa);
        oceaniaim = (ImageView) view.findViewById(R.id.oceania);
        europaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountriesFor(Continente.Europa);
            }
        });

        asiaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountriesFor(Continente.Asia);
            }
        });

        africaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountriesFor(Continente.Africa);
            }
        });

        americaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountriesFor(Continente.America);
            }
        });

        oceaniaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCountriesFor(Continente.Oceania);
            }
        });

        return view;
    }

    private void getCountriesFor(final Continente continente) {
        getCallFor(continente).enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if (response.isSuccessful()) {
                    List<Countries> countries = response.body();
                    if (countries != null && !countries.isEmpty()) {
                        Log.d("COUNTRIES", "################## Response ##################");
                        for(Countries country: countries) {
                            Log.d("COUNTRIES", country.getName());

                        }
                        Log.d("COUNTRIES", "################ End Response ################");

                        showFragmentFor(continente, countries);

                    } else {
                        showToastError("¡Ocurrio un error inesperado!");
                    }
                } else {
                    showToastError("¡Ocurrio un error inesperado!");
                }
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                showToastError(t.getLocalizedMessage());
            }
        });

    }

    private Call<List<Countries>> getCallFor(Continente continente) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestCountriesApi restCountriesApi = retrofit.create(RestCountriesApi.class);
        switch (continente) {
            case Asia:
                return restCountriesApi.getAsia();
            case America:
                return restCountriesApi.getAmericas();
            case Europa:
                return restCountriesApi.getEurope();
            case Africa:
                return restCountriesApi.getAfrica();
            case Oceania:
                return restCountriesApi.getOceania();
        }
        return null;
    }

    private void showFragmentFor(Continente continente, List<Countries> countries) {
        FragmentPaises fragmentPaises = new FragmentPaises();
        fragmentPaises.countries = countries;
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentPaises, FragmentPaises.TAG)
                .addToBackStack(FragmentPaises.TAG)
                .commit();
    }

    private void showToastError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }
}
