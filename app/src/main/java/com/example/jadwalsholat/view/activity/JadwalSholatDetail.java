package com.example.jadwalsholat.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.jadwalsholat.R;
import com.example.jadwalsholat.model.jadwal.Timings;

public class JadwalSholatDetail extends AppCompatActivity {
    TextView imsak, subuh, terbit, duhur, asar, magrib, isya, tgl, hijriah;
    String getImsak, getSubuh, getTerbit, getDuhur, getAsar, getMagrib, getIsya, getTgl, getHijriah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_detail);

        imsak = findViewById(R.id.tv_jam_imsak);
        subuh = findViewById(R.id.tv_jam_subuh);
        terbit = findViewById(R.id.tv_jam_terbit);
        duhur = findViewById(R.id.tv_jam_dhuhur);
        asar = findViewById(R.id.tv_jam_asar);
        magrib = findViewById(R.id.tv_jam_magrib);
        isya = findViewById(R.id.tv_jam_isya);
        tgl = findViewById(R.id.tv_tgl1);
        hijriah = findViewById(R.id.tv_hijriah);

        getImsak = getIntent().getExtras().getString("imsak");
        getSubuh = getIntent().getExtras().getString("subuh");
        getTerbit = getIntent().getExtras().getString("terbit");
        getDuhur = getIntent().getExtras().getString("duhur");
        getAsar = getIntent().getExtras().getString("asar");
        getMagrib = getIntent().getExtras().getString("magrib");
        getIsya = getIntent().getExtras().getString("isya");
        getTgl = getIntent().getExtras().getString("tgl");
        getHijriah = getIntent().getExtras().getString("hijriah");

//        getImsak = getIntent().getStringExtra("imsak");
//        getSubuh = getIntent().getStringExtra("subuh");
//        getTerbit = getIntent().getStringExtra("terbit");
//        getDuhur = getIntent().getStringExtra("duhur");
//        getAsar = getIntent().getStringExtra("asar");
//        getMagrib = getIntent().getStringExtra("magrib");
//        getIsya = getIntent().getStringExtra("isya");

        imsak.setText(getImsak);
        subuh.setText(getSubuh);
        terbit.setText(getTerbit);
        duhur.setText(getDuhur);
        asar.setText(getAsar);
        magrib.setText(getMagrib);
        isya.setText(getIsya);
        tgl.setText(getTgl);
        hijriah.setText(getHijriah);

    }
}
