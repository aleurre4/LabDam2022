package com.mdgz.dam.labdam2022;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.bdd.pojo.AlojamientoPojo;
import com.mdgz.dam.labdam2022.model.Alojamiento;

import java.util.List;

public class AlojamientosRecycleAdapter extends RecyclerView.Adapter<AlojamientosRecycleAdapter.AlojamientoViewHolder> {



    private List<AlojamientoPojo> mDataSet;
    public AlojamientosRecycleAdapter(List<AlojamientoPojo> myDataSet){

        this.mDataSet = myDataSet;

    }

    public static class AlojamientoViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView titulo;
        Button button;
        public AlojamientoViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.cardLog);
            titulo = itemView.findViewById(R.id.textAlojamiento);
            button = itemView.findViewById(R.id.buttonMasDetalles);





        }
    }

    @NonNull
    @Override
    public AlojamientoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        AlojamientoViewHolder vh = new AlojamientoViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlojamientoViewHolder holder, int position) {

        holder.titulo.setTag(position);
        holder.card.setTag(position);
        holder.button.setTag(position);
        AlojamientoPojo a = mDataSet.get(position);

        holder.titulo.setText(a.getTitulo());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",a.getId());
                Navigation.findNavController((View)view.getParent()).navigate(
                        R.id.action_resultadoBusquedaFragment_to_detalleAlojamientoFragment,bundle);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }





}
