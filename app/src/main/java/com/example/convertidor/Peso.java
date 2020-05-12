package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Peso extends AppCompatActivity {

    // Button bConvertir;
    RadioButton rbKGDE, rbGDE, rbMGDE, rbTMDE, rbTIDE, rbLIBRADE,rbOZDE, rbKGA, rbGA, rbMGA, rbTMA,
            rbTIA, rbLIBRAA, rbOZA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        // bConvertir      = findViewById(R.id.bConvertir);

    }

    public void SelecionadoDE() {

        RadioGroup rgDE = findViewById(R.id.rgDE);
        int intSeleccionadoDeID     = rgDE.getCheckedRadioButtonId();

        rbKGA       = findViewById(R.id.rbKGA);
        rbGA        = findViewById(R.id.rbGA);
        rbMGA       = findViewById(R.id.rbMGA);
        rbTMA       = findViewById(R.id.rbTMA);
        rbTIA       = findViewById(R.id.rbTIA);
        rbLIBRAA    = findViewById(R.id.rbLIBRAA);
        rbOZA       = findViewById(R.id.rbOZA);

        habilitarTodos(1);

        // Check which radio button was clicked
        switch(intSeleccionadoDeID) {
            case R.id.rbKGDE:
                rbKGA.setEnabled(false);
                break;

            case R.id.rbGDE:
                rbGA.setEnabled(false);
                break;

            case R.id.rbMGDE:
                rbMGA.setEnabled(false);
                break;

            case R.id.rbTMDE:
                rbTMA.setEnabled(false);
                break;

            case R.id.rbTIDE:
                rbTIA.setEnabled(false);
                break;

            case R.id.rbLIBRADE:
                rbLIBRAA.setEnabled(false);
                break;

            case R.id.rbOZDE:
                rbOZA.setEnabled(false);
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

    public void SelecionadoA() {

        RadioGroup rgA  = findViewById(R.id.rgA);
        int intSeleccionadoAID      = rgA.getCheckedRadioButtonId();

        rbKGDE      = findViewById(R.id.rbKGDE);
        rbGDE       = findViewById(R.id.rbGDE);
        rbMGDE      = findViewById(R.id.rbMGDE);
        rbTMDE      = findViewById(R.id.rbTMDE);
        rbTIDE      = findViewById(R.id.rbTIDE);
        rbLIBRADE   = findViewById(R.id.rbLIBRADE);
        rbOZDE      = findViewById(R.id.rbOZDE);

        habilitarTodos(0);

        // Check which radio button was clicked
        switch(intSeleccionadoAID) {

            case R.id.rbKGA:
                rbKGDE.setEnabled(false);
                break;

            case R.id.rbGA:
                rbGDE.setEnabled(false);
                break;

            case R.id.rbMGA:
                rbMGDE.setEnabled(false);
                break;

            case R.id.rbTMA:
                rbTMDE.setEnabled(false);
                break;

            case R.id.rbTIA:
                rbTIDE.setEnabled(false);
                break;

            case R.id.rbLIBRAA:
                rbLIBRADE.setEnabled(false);
                break;

            case R.id.rbOZA:
                rbOZDE.setEnabled(false);
                break;
        }
    }

    public void onClick(View view) {


        switch(view.getId()) {
            case R.id.bConvertir:
                ConvertirPeso();
                break;
            case R.id.rbKGDE:
            case R.id.rbGDE:
            case R.id.rbMGDE:
            case R.id.rbTMDE:
            case R.id.rbTIDE:
            case R.id.rbLIBRADE:
            case R.id.rbOZDE:
                SelecionadoDE();
                break;
            case R.id.rbKGA:
            case R.id.rbGA:
            case R.id.rbMGA:
            case R.id.rbTMA:
            case R.id.rbTIA:
            case R.id.rbLIBRAA:
            case R.id.rbOZA:
                SelecionadoA();
                break;
        }

    }

    private void ConvertirPeso() {

        EditText etEntradaPeso = findViewById(R.id.etEntradaPeso);

        String strEntradaPeso   = etEntradaPeso.getText().toString();
        if(strEntradaPeso.isEmpty()){
            Toast.makeText(getApplicationContext(),"El valor debe ser mayor a 0",
                    Toast.LENGTH_LONG).show();
            return;
        }
        Float entradaPesoFLT    = Float.parseFloat(strEntradaPeso);

        RadioGroup rgDE = findViewById(R.id.rgDE);
        int intSeleccionadoDeID     = rgDE.getCheckedRadioButtonId();

        RadioGroup rgA  = findViewById(R.id.rgA);
        int intSeleccionadoAID      = rgA.getCheckedRadioButtonId();

        Float intermedioDe;
        switch(intSeleccionadoDeID) {
            case R.id.rbKGDE:
                intermedioDe = entradaPesoFLT;
                break;

            case R.id.rbGDE:
                intermedioDe = entradaPesoFLT / 1000;
                break;

            case R.id.rbMGDE:
                intermedioDe = entradaPesoFLT / 1000000;
                break;

            case R.id.rbTMDE:
                intermedioDe = entradaPesoFLT * 1000;
                break;

            case R.id.rbTIDE:
                intermedioDe = entradaPesoFLT * 907.03f;
                break;

            case R.id.rbLIBRADE:
                intermedioDe = entradaPesoFLT / 2.205f;
                break;

            case R.id.rbOZDE:
                intermedioDe = entradaPesoFLT * 0.02835f;
                break;
            default:
                intermedioDe = 0f;
                break;
        }

        Float resultadoA;

        switch(intSeleccionadoAID) {

            case R.id.rbKGA:
                resultadoA = intermedioDe;
                break;

            case R.id.rbGA:
                resultadoA = intermedioDe * 1000;
                break;

            case R.id.rbMGA:
                resultadoA = intermedioDe * 1000000;
                break;

            case R.id.rbTMA:
                resultadoA = intermedioDe / 1000;
                break;

            case R.id.rbTIA:
                resultadoA = intermedioDe / 907.03f;
                break;

            case R.id.rbLIBRAA:
                resultadoA = intermedioDe * 2.205f;
                break;

            case R.id.rbOZA:
                resultadoA = intermedioDe / 0.02835f;
                break;
            default:
                resultadoA = 0f;
                break;
        }


        TextView tvResultadoPeso = findViewById(R.id.tvResultadoPeso);
        tvResultadoPeso.setText(resultadoA.toString());
    }
}
