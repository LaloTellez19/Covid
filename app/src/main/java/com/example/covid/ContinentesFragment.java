package com.example.covid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ContinentesFragment extends Fragment {
    static final String TAG = "ContinentesFragment";
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
               FragmentPaises fragmentPaises = new FragmentPaises();
               getActivity().getSupportFragmentManager().beginTransaction()
                       .replace(R.id.fragment_container, fragmentPaises, FragmentPaises.TAG)
                       .addToBackStack(FragmentPaises.TAG)
                       .commit();
            }
        });
        asiaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        africaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        americaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        oceaniaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
