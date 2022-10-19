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
import com.mdgz.dam.labdam2022.repo.CiudadRepository;

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

            NavHostFragment.findNavController(BusquedaFragment.this)
                    .navigate(R.id.action_busquedaFragment_to_resultadoBusquedaFragment);


        }
    });


    }

}