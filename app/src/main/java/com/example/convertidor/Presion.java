package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Presion extends AppCompatActivity {

    Spinner spPresionDe, spPresionA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presion);

        // Creo lista de unidades de Presion a usar
        List<String> unidadesDePresion = new ArrayList<>();
        unidadesDePresion.add("Pascal");
        unidadesDePresion.add("Bar");
        unidadesDePresion.add("KiloPascal");
        unidadesDePresion.add("MegaPascal");
        unidadesDePresion.add("PSI");
        unidadesDePresion.add("kgf/cm2");
        unidadesDePresion.add("inHg");
        unidadesDePresion.add("ATM");

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, unidadesDePresion);

        spPresionDe = findViewById(R.id.spPresionDe);
        spPresionA = findViewById(R.id.spPresionA);

        spPresionDe.setAdapter(adaptador);
        spPresionA.setAdapter(adaptador);
    }

    public void onClick(View view) {
        EditText etEntrada = findViewById(R.id.etEntradaPresion);
        String strEntradaPresion = etEntrada.getText().toString();

        if (strEntradaPresion.isEmpty()) {
            Toast.makeText(getApplicationContext(),R.string.valida_valor,Toast.LENGTH_LONG).show();
            return;
        }

        Float fltEntradaPresion = Float.parseFloat(strEntradaPresion);
        Float fltIntermedio;
        String strSeleccionadoDe = spPresionDe.getSelectedItem().toString();
        String strSeleccionadoA = spPresionA.getSelectedItem().toString();

        switch (strSeleccionadoDe){
            case ("Bar"):
                fltIntermedio = fltEntradaPresion * 100000;
                break;
            case ("MegaPascal"):
                fltIntermedio = fltEntradaPresion * 1000000;
                break;
            case ("PSI"):
                fltIntermedio = fltEntradaPresion * 6894.76f;
                break;
            case ("kgf/cm2"):
                fltIntermedio = fltEntradaPresion * 98066.52f;
                break;
            case ("inHg"):
                fltIntermedio = fltEntradaPresion * 3386.38f;
                break;
            case ("ATM"):
                fltIntermedio = fltEntradaPresion * 101325;
                break;
            case ("KiloPascal"):
                fltIntermedio = fltEntradaPresion * 1000;
                break;
            default: // Pascal
                fltIntermedio = fltEntradaPresion;
        }

        Float fltResultado;
        switch (strSeleccionadoA){
            case ("Bar"):
                fltResultado = fltIntermedio / 100000;
                break;
            case ("MegaPascal"):
                fltResultado = fltIntermedio / 1000000;
                break;
            case ("PSI"):
                fltResultado = fltIntermedio / 6894.76f;
                break;
            case ("kgf/cm2"):
                fltResultado = fltIntermedio / 98066.52f;
                break;
            case ("inHg"):
                fltResultado = fltIntermedio / 3386.38f;
                break;
            case ("ATM"):
                fltResultado = fltIntermedio / 101325;
                break;
            case ("KiloPascal"):
                fltResultado = fltIntermedio / 1000;
                break;
            default: //Pascal
                fltResultado = fltIntermedio;
        }

        TextView tvSalidaPresion = findViewById(R.id.tvSalidaPresion);
        tvSalidaPresion.setText(fltResultado.toString());

    }
}
