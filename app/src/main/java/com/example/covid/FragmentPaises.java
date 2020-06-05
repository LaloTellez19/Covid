package com.example.covid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentPaises extends Fragment {
    static final String TAG = "FragmentPaises";
    TextView buscar;
    RecyclerView lista;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.paisesfragment,container,false);
        buscar = (TextView) view.findViewById(R.id.txtBuscarPais);
        lista = (RecyclerView) view.findViewById(R.id.rvPaises);
        return view;
    }

}
