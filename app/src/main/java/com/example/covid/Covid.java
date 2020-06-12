package com.example.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

public class Covid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        this.setTitle("Seleccione un Continente");
        if (savedInstanceState == null) {
            ContinentesFragment continentesFragment = new ContinentesFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, continentesFragment, ContinentesFragment.TAG)
                    .commit();
        }
    }

}
