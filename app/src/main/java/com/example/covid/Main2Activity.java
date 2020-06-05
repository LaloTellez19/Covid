package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covid.Interface.RestCountriesApi;
import com.example.covid.Model.CountriesEurope;

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
        getPosts();
    }

    private void getPosts()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestCountriesApi restCountriesApi = retrofit.create(RestCountriesApi.class);
        Call<List<CountriesEurope>> call = restCountriesApi.getCountries();
        call.enqueue(new Callback<List<CountriesEurope>>() {
            //Respuesta
            @Override
            public void onResponse(Call<List<CountriesEurope>> call, Response<List<CountriesEurope>> response) {
                if(!response.isSuccessful())
                {
                    europe.setText("Codigo: "+response.code());
                    return;
                }
                List<CountriesEurope> europeList = response.body();
                for(CountriesEurope countriesEurope: europeList)
                {
                    String content = "";
                    content += countriesEurope.getName()+"\n\n";
                    europe.append(content);
                }
            }
            //Error
            @Override
            public void onFailure(Call<List<CountriesEurope>> call, Throwable t) {
                europe.setText(t.getMessage());
            }
        });
    }

}
