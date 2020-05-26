package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCocina extends AppCompatActivity {

    ImageView imagenDetalleCocina;
    TextView tvNombre, tvMedida1, tvMedida2, tvMedida3;

    MedidaCocina medidaCocina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cocina);

        imagenDetalleCocina = findViewById(R.id.imagenDetalleCocina);
        tvNombre            = findViewById(R.id.tvDetalleCocinaNombre);
        tvMedida1           = findViewById(R.id.tvDetalleCocinaMedida1);
        tvMedida2           = findViewById(R.id.tvDetalleCocinaMedida2);
        tvMedida3           = findViewById(R.id.tvDetalleCocinaMedida3);

        Intent intent = getIntent();

        if (intent.getExtras() != null ) {

            medidaCocina    = (MedidaCocina) intent.getSerializableExtra("item");

            imagenDetalleCocina.setImageResource(medidaCocina.getImagen());
            tvNombre.setText(medidaCocina.getNombre());
            tvMedida1.setText(medidaCocina.getMedida1());
            tvMedida2.setText(medidaCocina.getMedida2());
            tvMedida3.setText(medidaCocina.getMedida3());

        }
    }
}
