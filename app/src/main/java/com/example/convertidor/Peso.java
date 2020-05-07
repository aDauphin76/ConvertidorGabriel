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
    RadioButton rbKGDE, rbGDE, rbMGDE, rbTMDE, rbTIDE, rbLIBRADE,rbOZDE, rbKGA, rbGA, rbMGA, rbTMA,
            rbTIA, rbLIBRAA, rbOZA;
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

        rbKGA       = findViewById(R.id.rbKGA);
        rbGA        = findViewById(R.id.rbGA);
        rbMGA       = findViewById(R.id.rbMGA);
        rbTMA       = findViewById(R.id.rbTMA);
        rbTIA       = findViewById(R.id.rbTIA);
        rbLIBRAA    = findViewById(R.id.rbLIBRAA);
        rbOZA       = findViewById(R.id.rbOZA);

        habilitarTodos(1);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbKGDE:
                if (checked){
                    intermedioDe = entradaPesoFLT;
                    rbKGA.setEnabled(false);
                }
                break;

            case R.id.rbGDE:
                if (checked){
                    intermedioDe = entradaPesoFLT / 1000;
                    rbGA.setEnabled(false);
                }
                break;

            case R.id.rbMGDE:
                if (checked){
                    intermedioDe = entradaPesoFLT / 1000000;
                    rbMGA.setEnabled(false);
                }
                break;

            case R.id.rbTMDE:
                if (checked){
                    intermedioDe = entradaPesoFLT * 1000;
                    rbTMA.setEnabled(false);
                }
                break;

            case R.id.rbTIDE:
                if (checked){
                    intermedioDe = entradaPesoFLT * 907.03f;
                    rbTIA.setEnabled(false);
                }
                break;

            case R.id.rbLIBRADE:
                if (checked){
                    intermedioDe = entradaPesoFLT / 2.205f;
                    rbLIBRAA.setEnabled(false);
                }
                break;

            case R.id.rbOZDE:
                if (checked){
                    intermedioDe = entradaPesoFLT * 0.02835f;
                    rbOZA.setEnabled(false);
                }
                break;
        }
    }

    private void habilitarTodos(int i) {
        if (i == 1) {
            rbKGA.setEnabled(true);
            rbGA.setEnabled(true);
            rbMGA.setEnabled(true);
            rbTMA.setEnabled(true);
            rbTIA.setEnabled(true);
            rbLIBRAA.setEnabled(true);
            rbOZA.setEnabled(true);
        }else{
            rbKGDE.setEnabled(true);
            rbGDE.setEnabled(true);
            rbMGDE.setEnabled(true);
            rbTMDE.setEnabled(true);
            rbTIDE.setEnabled(true);
            rbLIBRADE.setEnabled(true);
            rbOZDE.setEnabled(true);
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

        rbKGDE      = findViewById(R.id.rbKGDE);
        rbGDE       = findViewById(R.id.rbGDE);
        rbMGDE      = findViewById(R.id.rbMGDE);
        rbTMDE      = findViewById(R.id.rbTMDE);
        rbTIDE      = findViewById(R.id.rbTIDE);
        rbLIBRADE   = findViewById(R.id.rbLIBRADE);
        rbOZDE      = findViewById(R.id.rbOZDE);

        habilitarTodos(0);

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.rbKGA:
                if (checked){
                    resultadoA = intermedioDe;
                    rbKGDE.setEnabled(false);
                }
                break;

            case R.id.rbGA:
                if (checked){
                    resultadoA = intermedioDe * 1000;
                    rbGDE.setEnabled(false);
                }
                break;

            case R.id.rbMGA:
                if (checked){
                    resultadoA = intermedioDe * 1000000;
                    rbMGDE.setEnabled(false);
                }
                break;

            case R.id.rbTMA:
                if (checked){
                    resultadoA = intermedioDe / 1000;
                    rbTMDE.setEnabled(false);
                }
                break;

            case R.id.rbTIA:
                if (checked){
                    resultadoA = intermedioDe / 907.03f;
                    rbTIDE.setEnabled(false);
                }
                break;

            case R.id.rbLIBRAA:
                if (checked){
                    resultadoA = intermedioDe * 2.205f;
                    rbLIBRADE.setEnabled(false);
                }
                break;

            case R.id.rbOZA:
                if (checked){
                    resultadoA = intermedioDe / 0.02835f;
                    rbOZDE.setEnabled(false);
                }
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    public void convertirPeso(View view) {

        TextView tvResultadoPeso = findViewById(R.id.tvResultadoPeso);

        tvResultadoPeso.setText(resultadoA.toString());
    }
}
