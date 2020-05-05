package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Peso extends AppCompatActivity {

    EditText etEntradaPeso;
    Button bConvertir;
    Float intermedioDe;
    Float resultadoA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        etEntradaPeso   = findViewById(R.id.etEntradaPeso);
        bConvertir      = findViewById(R.id.bConvertir);

    }

    public void SelecionadoDE(View view) {

        String entradaPesoSTR   = etEntradaPeso.getText().toString();

        if(entradaPesoSTR.isEmpty()){
            Toast.makeText(getApplicationContext(),"El valor debe ser mayor a 0",
                    Toast.LENGTH_LONG).show();
            return;
        }

        boolean checked = ((RadioButton) view).isChecked();
        Float entradaPesoFLT    = Float.parseFloat(entradaPesoSTR);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbKGDE:
                if (checked)
                    intermedioDe = entradaPesoFLT;
                    break;

            case R.id.rbGDE:
                if (checked)
                    intermedioDe = entradaPesoFLT / 1000;
                break;

            case R.id.rbMGDE:
                if (checked)
                    intermedioDe = entradaPesoFLT / 1000000;
                break;

            case R.id.rbTMDE:
                if (checked)
                    intermedioDe = entradaPesoFLT * 1000;
                break;

            case R.id.rbTIDE:
                if (checked)
                    intermedioDe = entradaPesoFLT * 907.03f;
                break;

            case R.id.rbLIBRADE:
                if (checked)
                    intermedioDe = entradaPesoFLT / 2.205f;
                break;

            case R.id.rbOZDE:
                if (checked)
                    intermedioDe = entradaPesoFLT * 0.02835f;
                break;
        }
    }

    public void SelecionadoA(View view) {

        if(intermedioDe == null){
            Toast.makeText(getApplicationContext(),"El valor debe ser mayor a 0",
                    Toast.LENGTH_LONG).show();
            return;
        }

        bConvertir.setEnabled(true);
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.rbKGA:
                if (checked)
                    resultadoA = intermedioDe;
                break;

            case R.id.rbGA:
                if (checked)
                    resultadoA = intermedioDe * 1000;
                break;

            case R.id.rbMGA:
                if (checked)
                    resultadoA = intermedioDe * 1000000;
                break;

            case R.id.rbTMA:
                if (checked)
                    resultadoA = intermedioDe / 1000;
                break;

            case R.id.rbTIA:
                if (checked)
                    resultadoA = intermedioDe / 907.03f;
                break;

            case R.id.rbLIBRAA:
                if (checked)
                    resultadoA = intermedioDe * 2.205f;
                break;

            case R.id.rbOZA:
                if (checked)
                    resultadoA = intermedioDe / 0.02835f;
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void convertirPeso(View view) {

        TextView tvResultadoPeso = findViewById(R.id.tvResultadoPeso);

        tvResultadoPeso.setText(resultadoA.toString());
    }
}
