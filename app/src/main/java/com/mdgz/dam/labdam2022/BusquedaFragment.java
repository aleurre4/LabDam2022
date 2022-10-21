package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;
import com.mdgz.dam.labdam2022.model.BusquedaLog;
import com.mdgz.dam.labdam2022.repo.BusquedaLogRespository;
import com.mdgz.dam.labdam2022.repo.CiudadRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BusquedaFragment extends Fragment {


    private String tipos[] = {"Ambos","Departamentos","Hoteles"};
    private FragmentBusquedaBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBusquedaBinding.inflate(inflater,container,false);

        ArrayAdapter<CharSequence> adapterCiudad = new ArrayAdapter(getActivity().getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, CiudadRepository._CIUDADES);

        ArrayAdapter<CharSequence> adapterTipo = new ArrayAdapter(getActivity().getApplicationContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,tipos);

        binding.spinnerCiudad.setAdapter(adapterCiudad);
        binding.spinnerTipo.setAdapter(adapterTipo);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState){

    binding.buttonBuscar.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            guardarLog();
            NavHostFragment.findNavController(BusquedaFragment.this)
                    .navigate(R.id.action_busquedaFragment_to_resultadoBusquedaFragment);
        }

    });



    }


    public void guardarLog(){

        BusquedaLog log= new BusquedaLog();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDateandTime = simpleDateFormat.format(new Date());

try{
        log.setId(1);
        log.setHora(currentDateandTime);
        log.setCantidadPersonas(Integer.parseInt(binding.editTextCantidad.getText().toString()));
        log.setTipo(binding.spinnerTipo.getSelectedItem().toString());
        log.setCiudad(binding.spinnerCiudad.getSelectedItem().toString());
        log.setPrecioMin(binding.editMin.getText().toString());
        log.setPrecioMax(binding.editMax.getText().toString());
        log.setCantidadResultados(2);
        log.setWifi(binding.checkWifi.createAccessibilityNodeInfo().isChecked());
        BusquedaLogRespository repositorio =  new BusquedaLogRespository(this.getContext());
        repositorio.agregar(log);}
catch(Exception e){

 System.out.println(e.getMessage());
}
    }


}