package com.example.covid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.Model.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener{

    List<Countries> countries;
    private View.OnClickListener listener;

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(countries.get(position));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
        {
            listener.onClick(v);
        }
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;

        ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
        }

        void asignarDatos(Countries country) {
            dato.setText(country.getName());
        }
    }

}
