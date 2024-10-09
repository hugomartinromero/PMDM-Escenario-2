package com.fireboy.escenario2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgOpciones;
    ArrayList<RadioButton> rbInfo = new ArrayList<>();
    Spinner spInfo;
    ArrayList<String> opciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgOpciones = findViewById(R.id.rgOpciones);
        spInfo = findViewById(R.id.spInfo);
        rbInfo.add(findViewById(R.id.rbInfo1));
        rbInfo.add(findViewById(R.id.rbInfo2));
        rbInfo.add(findViewById(R.id.rbInfo3));

        opciones.add("Ciudades");
        opciones.add("Frutas");
        opciones.add("Coches");

        spInfo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones));

        spInfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                actualizarInfo(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    @SuppressLint("SetTextI18n")
    private void actualizarInfo(int pos) {
        switch (pos) {
            case 0:
                rbInfo.get(0).setText("Sevilla");
                rbInfo.get(1).setText("Huelva");
                rbInfo.get(2).setText("Cádiz");
                break;
            case 1:
                rbInfo.get(0).setText("Manzana");
                rbInfo.get(1).setText("Naranja");
                rbInfo.get(2).setText("Piña");
                break;
            case 2:
                rbInfo.get(0).setText("Seat");
                rbInfo.get(1).setText("Renault");
                rbInfo.get(2).setText("Ford");
                break;
        }
    }
}