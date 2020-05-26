package com.example.convertidor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

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

    public class CocinaAdapter extends BaseAdapter implements Filterable {

        private List<MedidaCocina> itemsModelList;
        private List<MedidaCocina> itemsModelListFiltered;
        private Context context;

        public CocinaAdapter(List<MedidaCocina> itemsModelList, Context context) {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered = itemsModelList;
            this.context = context;
        }


        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.fila_cocina,null);

            TextView tvNombreUnidad = view.findViewById(R.id.tvNombreUnidad);
            TextView tvMedida1      = view.findViewById(R.id.tvMedida1);
            TextView tvMedida2      = view.findViewById(R.id.tvMedida2);
            TextView tvMedida3      = view.findViewById(R.id.tvMedida3);
            ImageView imagenMedida  = view.findViewById(R.id.imagenCocina);

            tvNombreUnidad.setText(itemsModelListFiltered.get(position).getNombre());
            tvMedida1.setText(itemsModelListFiltered.get(position).getMedida1());
            tvMedida2.setText(itemsModelListFiltered.get(position).getMedida2());
            tvMedida3.setText(itemsModelListFiltered.get(position).getMedida3());
            imagenMedida.setImageResource(itemsModelListFiltered.get(position).getImagen());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Cocina.this,DetalleCocina.class).putExtra("item",itemsModelListFiltered.get(position)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.length() == 0){
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    }else{
                        String searchSTR = constraint.toString().toLowerCase();
                        List<MedidaCocina> resultData = new ArrayList<>();
                        for (MedidaCocina medidaCocina:itemsModelList) {
                            if(medidaCocina.getNombre().toLowerCase().contains(searchSTR)){
                                resultData.add(medidaCocina);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }

                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered = (List<MedidaCocina>) results.values;

                    notifyDataSetChanged();

                }
            };

            return filter;
        }
    }

}
