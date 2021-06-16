package com.example.jadwalsholat.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jadwalsholat.R;
import com.example.jadwalsholat.database.DatabaseSaran;
import com.example.jadwalsholat.database.SaranModel;

public class KritikActivity extends AppCompatActivity {

    private DatabaseSaran databaseSaran;
    private Button btnLihatData, btnSimpan;
    private EditText etNama,etSaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saran);

        btnLihatData = findViewById(R.id.activitykritik_btn_lihatdata);
        btnSimpan = findViewById(R.id.activitykritik_btn_simpan);

        etNama = findViewById(R.id.activitykritik_et_nama);
        etSaran = findViewById(R.id.activitykritik_et_saran);

        databaseSaran = DatabaseSaran.initDbs(getApplicationContext());

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SaranModel saranModel = new SaranModel();
                    saranModel.setNama(etNama.getText().toString());
                    saranModel.setSaran(etSaran.getText().toString());

                    databaseSaran.saranDAO().insertSaran(saranModel);

                    Log.d("SaranActivity" , "sukses ");
                    Toast.makeText(getApplicationContext(),"Tersimpan", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("SaranActivity" , "gagal menyimpan , msg : "+ex.getMessage());
                    Toast.makeText(getApplicationContext(),"Gagal Menyimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });


        findViewById(R.id.activitykritik_btn_lihatdata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KritikActivity.this, com.example.jadwalsholat.view.activity.ReadKritikActivity.class));

            }
        });

    }
}
