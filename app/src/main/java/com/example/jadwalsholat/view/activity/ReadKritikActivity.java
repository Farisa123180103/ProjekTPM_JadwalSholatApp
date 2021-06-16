package com.example.jadwalsholat.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.adapter.SaranAdapter;
import com.example.jadwalsholat.database.DatabaseSaran;
import com.example.jadwalsholat.database.SaranModel;


public class ReadKritikActivity extends AppCompatActivity {

    private SaranAdapter saranAdapter;
    private RecyclerView rvSaran;
    private DatabaseSaran databaseSaran;
    private ArrayList<SaranModel> listSaran = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_saran);

        rvSaran = findViewById(R.id.readactivity_rv_saran);
        saranAdapter = new SaranAdapter(getApplicationContext());
        saranAdapter.notifyDataSetChanged();

        if (databaseSaran == null){
            databaseSaran = DatabaseSaran.initDbs(getApplicationContext());
        }

        listSaran.addAll(databaseSaran.saranDAO().getSaransaran());
        saranAdapter.setData(listSaran);

        rvSaran.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvSaran.setAdapter(saranAdapter);


    }
}
