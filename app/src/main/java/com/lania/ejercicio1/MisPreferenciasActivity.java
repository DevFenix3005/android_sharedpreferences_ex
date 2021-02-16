package com.lania.ejercicio1;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

public class MisPreferenciasActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager prefMgr = getPreferenceManager();
        prefMgr.setSharedPreferencesName(StaticValues.PREFERENCE_FILE);


        addPreferencesFromResource(R.xml.mispreferencias);
    }
}
