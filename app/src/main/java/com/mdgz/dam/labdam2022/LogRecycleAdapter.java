package com.mdgz.dam.labdam2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.model.BusquedaLog;

import java.util.List;

public class LogRecycleAdapter extends RecyclerView.Adapter<LogRecycleAdapter.LogViewHolder> {

    private List<BusquedaLog> mDataSet;


    public LogRecycleAdapter(List<BusquedaLog> myDataSet){

        this.mDataSet = myDataSet;


    }

    public static class LogViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView textCantidad;
        TextView textCiudad;
        TextView textTipo;
        TextView textMin;
        TextView textMax;
        TextView textWifi;
        TextView textHora;



        public LogViewHolder(@NonNull View itemView) {

            super(itemView);

            card = itemView.findViewById(R.id.cardLog);
            textCantidad = itemView.findViewById(R.id.textCantidadLog);
            textCiudad = itemView.findViewById(R.id.textCiudadLog);
            textTipo = itemView.findViewById(R.id.textTipoLog);
            textMin = itemView.findViewById(R.id.textMinLog);
            textMax = itemView.findViewById(R.id.textMaxLog);
            textWifi = itemView.findViewById(R.id.textWifiLog);
            textHora = itemView.findViewById(R.id.textHoraLog);


        }
    }


    @NonNull
    @Override
    public LogRecycleAdapter.LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_card,parent,false);

        LogRecycleAdapter.LogViewHolder vh = new LogRecycleAdapter.LogViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull LogRecycleAdapter.LogViewHolder holder, int position) {

        holder.textCantidad.setTag(position);
        holder.card.setTag(position);
        holder.textHora.setTag(position);
        holder.textCiudad.setTag(position);
        holder.textMin.setTag(position);
        holder.textMax.setTag(position);
        holder.textTipo.setTag(position);
        holder.textWifi.setTag(position);


        BusquedaLog b = mDataSet.get(position);



        holder.textCantidad.setText(b.getCantidadPersonas().toString());
        holder.textTipo.setText(b.getTipo().toString());
        holder.textMin.setText(b.getPrecioMin().toString());
        holder.textMax.setText(b.getPrecioMax().toString());
        holder.textCiudad.setText(b.getCiudad().toString());
        holder.textHora.setText(b.getHora().toString());
        holder.textWifi.setText(b.getWifi().toString());




    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }





}
