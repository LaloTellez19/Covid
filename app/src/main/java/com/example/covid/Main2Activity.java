package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.covid.Interface.RestApiCovid;
import com.example.covid.Model.Case;
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
        getCase();
    }
    private void getCase()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RestApiCovid restApiCovid = retrofit.create(RestApiCovid.class);
        Call<List<Case>> call = restApiCovid.getCases();
        call.enqueue(new Callback<List<Case>>() {
            @Override
            public void onResponse(Call<List<Case>> call, Response<List<Case>> response) {
                if(!response.isSuccessful())
                {
                    europe.setText("Codigo: "+response.code());
                    return;
                }
                List<Case> caseList = response.body();
                for(Case caseworld: caseList)
                {
                    String content = "";
                    content += caseworld.getCountry()+"\n";
                    content += caseworld.getNewConfirmed()+"\n";
                    content += caseworld.getTotalConfirmed()+"\n";
                    content += caseworld.getNewDeaths()+"\n";
                    content += caseworld.getTotalDeaths()+"\n";
                    content += caseworld.getNewRecovered()+"\n";
                    content += caseworld.getTotalRecovered()+"\n\n";
                    europe.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Case>> call, Throwable t) {
                europe.setText(t.getMessage());
            }
        });

    }
}
