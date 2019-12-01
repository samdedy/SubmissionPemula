package com.sam.alatmusiktradisional;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDaerahAsal;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    int[] dataDetailPhoto = {R.drawable.calung,R.drawable.angklung,R.drawable.kendang,R.drawable.saron,R.drawable.karinding,R.drawable.kolintang,R.drawable.rebab,R.drawable.rebana,R.drawable.saluang,R.drawable.talempong};
    private AlatMusikAdapter adapter;
    private ArrayList<AlatMusik> alatMusiks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new AlatMusikAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        // Menyiapkan data dari resource
        prepare();

        // Menambahkan data dari resource ke adapter
        addItem();

        // Memberikan aksi pada listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this, alatMusiks.get(i).getName(),Toast.LENGTH_SHORT).show();
                // on clickitem go to detail activity

                // set new intent to DetailActivity class
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                // put  names selected
                intent.putExtra("dataDetailPhoto", dataDetailPhoto[i]);
                intent.putExtra("dataName", dataName[i]);
                intent.putExtra("dataDescription", dataDescription[i]);


                // start activity
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDaerahAsal = getResources().getStringArray(R.array.data_daerah_asal);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        alatMusiks = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            AlatMusik alatMusik = new AlatMusik();
            alatMusik.setPhoto(dataPhoto.getResourceId(i,-1));
            alatMusik.setName(dataName[i]);
            alatMusik.setAlamatAsal(dataDaerahAsal[i]);
            alatMusiks.add(alatMusik);
        }

        adapter.setAlatMusiks(alatMusiks);
    }
}
