package com.example.covid;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.Model.Countries;

import java.util.ArrayList;
import java.util.List;

public class FragmentPaises extends Fragment {
    static final String TAG = "FragmentPaises";
    EditText buscar;
    RecyclerView lista;
    ProgressBar progress;
    List<Countries> countries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Paises: " + countries.toString());
        View view = inflater.inflate(R.layout.paisesfragment,container,false);
        buscar = (EditText) view.findViewById(R.id.txtBuscarPais);
        lista =(RecyclerView)view.findViewById(R.id.idRecyclerFragmet);
        lista.setLayoutManager(new LinearLayoutManager(getContext()));
        AdapterDatos adapterDatos = new AdapterDatos(countries);
        lista.setAdapter(adapterDatos);
        return view;
    }
}
