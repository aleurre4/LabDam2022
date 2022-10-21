package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdgz.dam.labdam2022.databinding.FragmentLogBinding;
import com.mdgz.dam.labdam2022.databinding.FragmentResultadoBusquedaBinding;
import com.mdgz.dam.labdam2022.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.repo.BusquedaLogRespository;


public class FragmentoLogBusqueda extends Fragment {

    private FragmentLogBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= FragmentLogBinding.inflate(inflater,container,false);
        recyclerView = binding.recycle;
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        BusquedaLogRespository rep = new BusquedaLogRespository(this.getContext());

        mAdapter =  new LogRecycleAdapter(rep.listarTodos());

        recyclerView.setAdapter(mAdapter);



        return binding.getRoot();
    }
}