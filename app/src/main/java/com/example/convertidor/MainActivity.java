package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        switch(view.getId()) {
            case R.id.tvPeso:
                Intent lanzarPeso = new Intent(MainActivity.this, Peso.class);
                startActivity(lanzarPeso);
                break;
            case R.id.tvPresion:
                Intent lanzarPresion = new Intent(MainActivity.this, Presion.class);
                startActivity(lanzarPresion);
                break;
        }
    }
}
