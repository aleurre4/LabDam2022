package com.mdgz.dam.labdam2022;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragment;
import androidx.preference.PreferenceFragmentCompat;


public class SettingsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction().
                replace(android.R.id.content, new SettingsFragment()).commit();

    }


    public static class SettingsFragment extends PreferenceFragmentCompat {


        @Override
        public void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.root_preferences);


        }

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        }

    }


}
