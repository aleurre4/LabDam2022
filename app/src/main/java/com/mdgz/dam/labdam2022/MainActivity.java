package com.mdgz.dam.labdam2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;
import com.mdgz.dam.labdam2022.repo.BusquedaLogRespository;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        toolbar = binding.materialToolbar;

        toolbar.setTitle("Holiss");

        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        File archivo = new File("/data/user/0/com.mdgz.dam.labdam2022/files/" + "busquedas.json");

        Boolean guardado = preferences.getBoolean("log", false);
        MenuItem item = menu.findItem(R.id.itemLog);



        if (guardado) {

            item.setVisible(true);

            if (!archivo.exists()) {
                try {
                    File file = new File("/data/user/0/com.mdgz.dam.labdam2022/files/", "busquedas" + ".json");
                    file.createNewFile();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

            BusquedaLogRespository rep = new BusquedaLogRespository(this);

        } else {

           if (archivo.exists()) {
                archivo.delete();
            }
           item.setVisible(false);
        }


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.itemConfiguracion:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                break;

            case R.id.itemLog:
                NavController navController = Navigation.findNavController(MainActivity.this, R.id.navigation);
                navController.navigate(R.id.fragmentoLogBusqueda);
                break;


        }
        return true;
    }


}