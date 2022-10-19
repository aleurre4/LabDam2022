package com.mdgz.dam.labdam2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


     private ActivityMainBinding binding;
     private MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        toolbar = binding.materialToolbar;

        toolbar.setTitle("Holiss");

    setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }




}