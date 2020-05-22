package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Cocina extends AppCompatActivity {


    CocinaAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);

        ListView lvCocinaLista = findViewById(R.id.lvCocinaLista);

        List<MedidaCocina> listaCocina = new ArrayList<>();

        listaCocina.add(new MedidaCocina("Harina", "140g", "70g", "35g", R.drawable.flour));
        listaCocina.add(new MedidaCocina("Azucar", "200g", "100g", "50g",R.drawable.sugar));
        adaptador = new CocinaAdapter(listaCocina,getApplicationContext());

        lvCocinaLista.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptador.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_view){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
