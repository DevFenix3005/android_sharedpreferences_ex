package com.lania.ejercicio1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.modificar_button);
        button.setOnClickListener(this);

        MaterialToolbar materialToolbar = findViewById(R.id.toolbar);
        materialToolbar.setOnMenuItemClickListener(this::onOptionsItemSelected);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent("com.lania.ejercicio1.MisPreferenciasActivity");
                startActivity(intent);
                break;
            case R.id.menu_show:
                SharedPreferences appPrefs = getSharedPreferences(StaticValues.PREFERENCE_FILE, MODE_PRIVATE);

                String firstname = appPrefs.getString(StaticValues.PREFERENCE_FILE_FIRSTNAME, "");
                String lastname = appPrefs.getString(StaticValues.PREFERENCE_FILE_LASTNAME, "");
                String nickname = appPrefs.getString(StaticValues.PREFERENCE_FILE_NICKNAME, "");
                boolean active = appPrefs.getBoolean(StaticValues.PREFERENCE_FILE_ACTIVE, false);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Nombre: ").append(firstname).append("\n");
                stringBuilder.append("Apellido: ").append(lastname).append("\n");
                stringBuilder.append("Sobrenombre: ").append(nickname).append("\n");
                stringBuilder.append("Status: ").append(active ? "Activado" : "Desactivado");

                DisplayText(stringBuilder.toString());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.modificar_button:
                SharedPreferences appPrefs2 = getSharedPreferences(StaticValues.PREFERENCE_FILE, MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = appPrefs2.edit();
                prefsEditor.putString(StaticValues.PREFERENCE_FILE_FIRSTNAME, ((EditText) findViewById(R.id.nombre_field)).getText().toString());
                prefsEditor.putString(StaticValues.PREFERENCE_FILE_LASTNAME, ((EditText) findViewById(R.id.apellido_field)).getText().toString());
                prefsEditor.commit();

        }
    }

    private void DisplayText(String t) {
        Toast.makeText(getBaseContext(), t, Toast.LENGTH_LONG).show();
    }
}