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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.Model.Countries;

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
        progress=(ProgressBar)view.findViewById(R.id.pbPaises);
        progress.getIndeterminateDrawable().setColorFilter(Color.parseColor("#0091EA"), PorterDuff.Mode.SRC_IN);
        progress.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
            }
        },2000);
        return view;
    }
}
