package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covid.Interface.RestCountriesApi;
import com.example.covid.Model.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {
    private TextView europe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        europe = (TextView) findViewById(R.id.json);
        getAsia();
    }

    private void getEurope()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestCountriesApi restCountriesApi = retrofit.create(RestCountriesApi.class);
        Call<List<Countries>> call = restCountriesApi.getEurope();
        call.enqueue(new Callback<List<Countries>>() {
            //Respuesta
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if(!response.isSuccessful())
                {
                    europe.setText("Codigo: "+response.code());
                    return;
                }
                List<Countries> europeList = response.body();
                for(Countries countriesEurope: europeList)
                {
                    String content = "";
                    content += countriesEurope.getName()+"\n\n";
                    europe.append(content);
                }
            }
            //Error
            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                europe.setText(t.getMessage());
            }
        });
    }
    private void getAsia()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestCountriesApi restCountriesApi = retrofit.create(RestCountriesApi.class);
        Call<List<Countries>> call = restCountriesApi.getAsia();
        call.enqueue(new Callback<List<Countries>>() {
            //Respuesta
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if(!response.isSuccessful())
                {
                    europe.setText("Codigo: "+response.code());
                    return;
                }
                List<Countries> asiaList = response.body();
                for(Countries countriesAsia: asiaList)
                {
                    String content = "";
                    content += countriesAsia.getName()+"\n\n";
                    europe.append(content);
                }
            }
            //Error
            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                europe.setText(t.getMessage());
            }
        });
    }

}
