package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mdgz.dam.labdam2022.bdd.AppDatabase;
import com.mdgz.dam.labdam2022.bdd.pojo.AlojamientoPojo;
import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.repo.AlojamientoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;


public class ResultadoBusquedaFragment extends Fragment {


    private static List<AlojamientoPojo> alojamientos = new ArrayList<>();
    private FragmentResultadoBusquedaBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

                alojamientos = AppDatabase.getInstance(getActivity().getApplicationContext()).alojamientoDAO().loadAll();

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentResultadoBusquedaBinding.inflate(inflater,container,false);
        recyclerView = binding.recycle;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);









        mAdapter =  new AlojamientosRecycleAdapter(alojamientos);


        recyclerView.setAdapter(mAdapter);



        return binding.getRoot();
    }

    public static List<AlojamientoPojo> getAlojamientos() {
        return alojamientos;
    }

}