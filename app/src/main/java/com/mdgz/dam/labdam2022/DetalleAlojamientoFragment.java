package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.databinding.FragmentDetalleAlojamientoBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.repo.AlojamientoRepository;

import java.security.acl.AclEntry;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DetalleAlojamientoFragment extends Fragment {



    private FragmentDetalleAlojamientoBinding binding;
    private Double precioBase;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleAlojamientoBinding.inflate(inflater,container,false);

        Integer id = getArguments().getInt("id");
        Alojamiento a = getAlojamiento(id);
        precioBase = a.getPrecioBase();
        binding.tituloAlojamiento.setText(a.getTitulo());
        binding.textDescripcion.setText(a.getDescripcion());
        binding.textCapacidad.setText("Capacidad: " + a.getCapacidad());
        binding.textPrecio.setText("Precio Base: " + precioBase);
       try {
           binding.textUbicacion.setText("Ubicaion: " + a.getUbicacion().toString());
       }catch (Exception e )
       {
           binding.textUbicacion.setText("Ubicaion: " + "Ni idea perri");

       }



       eventos();



        return binding.getRoot();


    }

    private Alojamiento getAlojamiento(Integer id){


        for(Alojamiento a: AlojamientoRepository._ALOJAMIENTOS){

            if(a.getId()==id){
                return a;
            }
        }


return null;


    }

    public void eventos(){

        binding.buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaIda,fechaVuelta;
                Double costoTotal;
                int dias;
                try {
                    fechaIda = format.parse(binding.editFechaIda.getText().toString());
                    fechaVuelta = format.parse(binding.editFechaVuelta.getText().toString());

                    dias = (int) ((fechaVuelta.getTime()-fechaIda.getTime())/86400000);
                    System.out.println(dias);
                    costoTotal = dias * precioBase;

                    binding.textCalcular.setText(costoTotal.toString());

                }catch (Exception e) {
                     System.out.println(e.getMessage());
                }




            }
        });


    }

}