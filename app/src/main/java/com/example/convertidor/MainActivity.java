package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG_MAIN = "MAIN ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG_MAIN,"Se corrió onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(TAG_MAIN,"Se corrió onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG_MAIN,"Se corrió onResume");

    }

    public void onClick(View view) {
        Intent lanzar = null;
        switch(view.getId()) {
            case R.id.tvPeso:
                lanzar = new Intent(MainActivity.this, Peso.class);
                break;
            case R.id.tvPresion:
                lanzar = new Intent(MainActivity.this, Presion.class);
                break;
            case R.id.tvCocina:
                lanzar = new Intent(MainActivity.this, Cocina.class);
                break;
            default:
                Toast.makeText(getApplicationContext(),"No implementado aún",Toast.LENGTH_SHORT).show();
                break;
        }
        if (lanzar != null) startActivity(lanzar);

    }
}
